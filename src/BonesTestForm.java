import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class BonesTestForm extends JPanel
{
	static FormGenerator form;
	static LabelComboBox lcb;
	
	BonesTestForm()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(450, 300));
		
		form = new FormGenerator(3, 2);
		
		form.addLabelComboBox("Category");
		form.addLabelTextBox("Where is this Bone?");
		form.addButton("New Bone");
		
		form.addLabelTextBox("Where is this Muscle?");
		form.addButton("New Muscle");
		
		lcb = form.getLCB("Category");
		lcb.populateBoxFrData(getItems());
		
		JButton newBone = form.getButton("New Bone");
		newBone.addActionListener(new boneListener());
		
		JButton newMuscle = form.getButton("New Muscle");
		newMuscle.addActionListener(new muscleListener());
		
		add(form);
	}
	
	private class boneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = "SELECT * FROM bones WHERE category_id = '" + lcb.getSelectedItemID() + "' ORDER BY RAND() LIMIT 0,1";
			ResultSet rset = DB.queryResults(command);
			String randomBone = "";
			try
			{
			    while(rset.next())
			    {
				    randomBone = rset.getString("boneName");
			    }
			    DB.conn.close();
			}
			catch(SQLException ex)
			{
				System.out.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}
			BonesTestForm.form.setCompText("Where is this Bone?", randomBone);
		}
	}
	
	private class muscleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = "SELECT * FROM muscles WHERE category_id = '" + lcb.getSelectedItemID() + "' ORDER BY RAND() LIMIT 0,1";
			ResultSet rset = DB.queryResults(command);
			String randomMuscle = "";
			try
			{
			    while(rset.next())
			    {
				    randomMuscle = rset.getString("muscleName");
			    }
			    DB.conn.close();
			}
			catch(SQLException ex)
			{
				System.out.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}
			BonesTestForm.form.setCompText("Where is this Muscle?", randomMuscle);
		}
	}
	
	public ArrayList getItems()
	{
		String command = "SELECT ID, Name FROM categories";
		ResultSet rset = DB.queryResults(command);
		ArrayList items  = new ArrayList();
		
		try
		{
		    while(rset.next())
		    {
		        String[] idName = new String[2];
		        idName[0] = "" + rset.getInt("ID");
		        idName[1] = rset.getString("Name");
			    items.add(idName);
		    }
		    DB.conn.close();
		    return items;
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/*public ArrayList getItems()
	{
		String command = "SELECT Category FROM bones";
		ResultSet rset = DB.queryResults(command);

		ArrayList items  = new ArrayList();
		try
		{
			int index = 0;
		    while(rset.next())
		    {
			    items.add(rset.getString("category"));
			    System.out.println("" + index);
			    index++;
		    }
		    DB.conn.close();
		    return items;
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}*/
}
