package project.fish.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatsSource {
	private static DatsSource dataSource = new DatsSource();
	private DatsSource() {};
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public static DatsSource getInstance() {
		return dataSource;
	}
	
	
	private void dbConfig() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileInputStream(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		public Connection getConnection() {
			dbConfig();
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("DB 연결 성공!!!");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			return conn;
		
	}
}
