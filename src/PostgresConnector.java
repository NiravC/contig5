import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgresConnector {
	private Connection con;
	
	public PostgresConnector() throws ClassNotFoundException, SQLException{

	    Class.forName("org.postgresql.Driver");
			
		String connectionURL = "jdbc:postgresql://localhost:5432/crackle";
			
		con = DriverManager.getConnection(connectionURL, "postgres", "pass");


	}
	
	public ResultSet query(String q) throws SQLException{
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(q);
		
		return rs;
	}
	
	public void update(String q) throws SQLException{

		Statement stmt = con.createStatement();
		stmt.executeUpdate(q);

	}
}
