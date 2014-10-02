import java.sql.*;

public class DB 
{
	static Connection conn;
	static final String connectionString = "jdbc:mysql://localhost:3306/garroyo_0daveshobbieshop?user=garroyo0_main&password=Asdfghj#1";
	
	public static void executeQuery(String command)
	{
		conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionString);
			if(conn != null)
			{
				Statement stmt = conn.createStatement();
				stmt.execute(command);
				conn.close();
			}
			
		}
		catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		catch (Exception ex)
		{
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}	
	}
	
	public static ResultSet queryResults(String command)
	{
	    conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionString);
			if(conn != null)
			{
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(command);
				return rset;
			}
			
		}
		catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
		catch (Exception ex)
		{
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}	
		return null;
	}
}
