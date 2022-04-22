package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection opnConnection() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost;database=QLXEMAY1;";
		String username = "sa";
		String password = "123456";
		Connection con = DriverManager.getConnection(connectionUrl, username, password);
		return con;
	}
}
