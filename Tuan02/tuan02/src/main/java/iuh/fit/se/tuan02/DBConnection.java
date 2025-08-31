package iuh.fit.se.tuan02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public DBConnection() {
		super();
		// TODO Auto-generated constructor stub
		}
		public static Connection getConnection() {
		 Connection connection = null;
		 
		 String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;encrypt=false;";
		 String jdbcUsername = "sa";
		 
		 String jdbcPassword = "sqlsmile";
		 try {
		 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 connection = DriverManager.getConnection(jdbcURL, 
		jdbcUsername, jdbcPassword);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return connection;
		 }

}
