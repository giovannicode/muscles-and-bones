

import java.applet.Applet;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JApplet;

public class bones extends JApplet
{
	/*public static void main(String[] args)
	{
		Connection conn = null;
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daveshobbieshop?user=root&password=password");

		    if(conn != null)
		    {
		    	Statement statement = conn.createStatement();
				statement.execute("CREATE TABLE muscles(" +
						"ID INT UNSIGNED NOT NULL AUTO_INCREMENT," +
						"category_id INT NOT NULL," +
						"muscleName VARCHAR(40) NOT NULL," +
						"PRIMARY KEY (ID))");
			     System.out.println("Connection sucess!");
			     conn.close();
		    }
		    else
		    {
		    	System.out.println("Connection Failed!");
		    }
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		catch( Exception ex)
		{
			
		}	
	}*/
	
	/*public static void main (String[] args)
	{
       getItems();	
	}*/
	
	/*public static void getItems()
	{*/
		
		//String command = "SELECT category FROM bones";
		//ResultSet rset = DB.queryResults(command);
		/*int rowCount = 0;
		try{rowCount = rset.getRow();}catch(Exception ex){}*/
		/*ArrayList items  = new ArrayList();
		try
		{
			int id = 0;
			String category = "";
			
		    while(rset.next())
		    {
		    	
		        //id = rset.getInt("ID");
			    category = rset.getString("category");
			    
			    if(category.equals("Facial"))
			    {
			    	System.out.println("This code was exec");
			    	DB.executeQuery("UPDATE bones SET category_id = 9 WHERE category = 'Facial'");
			    	DB.executeQuery("UPDATE bones SET category_id = 9 WHERE category = 'Facial'");
			    	DB.executeQuery("UPDATE bones SET category_id = 9 WHERE category = 'Facial'");
			    	System.out.println("This was excecuted");
			    }
		    }
		    DB.conn.close();
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}*/
	
	
	bonesManagementForm panel;
	BonesTestForm testForm;
	categoryManagementForm form;
	
	public void init()
	{
       
		/*panel = new bonesManagementForm();
		getContentPane().add(panel);*/
		
		testForm = new BonesTestForm();
		getContentPane().add(testForm);
		
		/*form = new categoryManagementForm();
		getContentPane().add(form);*/
	}
}