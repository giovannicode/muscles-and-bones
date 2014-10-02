import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.*;

public class categoryManagementForm extends JPanel
{
	static FormGenerator form;
	static LabelComboBox lcbBox;
	
	categoryManagementForm()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(450, 300));
		
		form = new FormGenerator(4,2);
		
		form.addLabelComboBox("Category");
		form.addLabelTextBox("New Category");
		form.addButton("Enter new Category");
		
		add(form);
		
		lcbBox = form.getLCB("Category");
		JButton jb = form.getButton("Enter new Category");
		jb.addActionListener(new ButtonListener());
		lcbBox.populateBox(getItems());
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String newCat = categoryManagementForm.form.getCompText("New Category");
			DB.executeQuery("INSERT INTO categories VALUES(null,'" + newCat + "')");
			lcbBox.removeAllItems();
			lcbBox.populateBox(getItems());
		}
	}
	
	public ArrayList getItems()
	{
		String command = "SELECT Name FROM categories";
		ResultSet rset = DB.queryResults(command);
		/*int rowCount = 0;
		try{rowCount = rset.getRow();}catch(Exception ex){}*/
		ArrayList items  = new ArrayList();
		try
		{
			int index = 0;
		    while(rset.next())
		    {
			    items.add(rset.getString("Name"));
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
	}
}
