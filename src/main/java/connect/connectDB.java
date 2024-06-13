package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	private static Connection con = null;
	private static connectDB instance = new connectDB();

	public static connectDB getInstance() {
		if (instance == null) {
			instance = new connectDB();
		}
		return instance;
	}
	public void connect() {
		String userName = "sa";
		String password ="123456";
		String databaseName = "Digital";
		String url ="jdbc:sqlserver://localhost:1433;databasename="+databaseName;
		try {
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connect success");
		} catch (Exception e) {
			System.out.println("Connect fail");
		}
	}
	public Connection getConnection() {
		if (con == null) {
			connect();
		}
		return con;
	}
	public void disConnect() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Close fail");
		}
	}
}
