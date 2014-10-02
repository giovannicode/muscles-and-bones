import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class bonesManagementForm extends JPanel
{
	FormGenerator formGenerator;
	LabelComboBox lcbBox;
	
	public bonesManagementForm()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(450, 300));
		
		formGenerator = new FormGenerator(10, 2);
		
		formGenerator.addLabelComboBox("Category");
		formGenerator.addLabelTextBox("Bone Name");
		formGenerator.addLabelTextBox("Muscle Name");
		formGenerator.addButton("Enter new bone");
		formGenerator.addButton("Enter new muscle");
		
		add(formGenerator);
		
		lcbBox = formGenerator.getLCB("Category");
		lcbBox.populateBoxFrData(getItems());
		
		JButton btnEnter = formGenerator.getButton("Enter new bone");
		btnEnter.addActionListener(new boneListener());
		
		JButton btnMusEnter = formGenerator.getButton("Enter new muscle");
		btnMusEnter.addActionListener(new muscleListener());
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
	
	private class boneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = "INSERT INTO bones VALUES(null, '" + formGenerator.getLCB("Category").getSelectedItemID() + 
			                 "', '"  + formGenerator.getCompText("Bone Name") + "')";
			DB.executeQuery(command);
			formGenerator.getLTB("Bone Name").setText("");
		}
	}
	
	private class muscleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = "INSERT INTO muscles VALUES(null, '" + formGenerator.getLCB("Category").getSelectedItemID() + 
			                 "', '"  + formGenerator.getCompText("Muscle Name") + "')";
			DB.executeQuery(command);
			formGenerator.getLTB("Muscle Name").setText("");
		}
	}
}
