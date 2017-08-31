package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQL {
	public MySQL() {
	Connection conn = null;

	try {
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost/concesionaria?" +
	                                   "user=concesionaria&password=martin123");

	    // Do something with the Connection


	} catch (SQLException ex) {
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}
	
	}
	
}
