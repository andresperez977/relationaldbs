package relationaldbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

	private static String username = "postgres";
	private static String password = "Admin";
	
	
	public static Connection getConnection()  {
		try {
			return DriverManager.getConnection(postgresqlURL, username, password);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
}
