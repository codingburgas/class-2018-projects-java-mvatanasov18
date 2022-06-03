package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionModel {
	private Connection connection;

	public ConnectionModel() {
		try {
			
			Path currentDir = Paths.get("StudentAndTeachers");
			String pathToConfig=currentDir.toAbsolutePath()+"\\src\\resources\\config.properties";
			//System.out.println(pathToConfig);
			
			InputStream input = new FileInputStream(pathToConfig);

			Properties prop = new Properties();
			
			prop.load(input);
			
			// Get properties from the config file
			String user = prop.getProperty("db.user");
			String password = prop.getProperty("db.password");
			String dbName = prop.getProperty("db.name");
			String db=prop.getProperty("db");
			String connectionUrl = "jdbc:sqlserver://"+db+";database=" + dbName + ";user=" + user
					+ ";password=" + password;

			System.out.println("connecting.. ");
			connection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected. Martincho is happy");

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Marti is not happy");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	public Statement createStatement() throws SQLException {
		return connection.createStatement();
	}
	
	public PreparedStatement createPrepareStatement(String query) throws SQLException {
		return connection.prepareStatement(query);
	}

	public void closeConnection() throws SQLException {
		if (!connection.isClosed()) {

			connection.close();
			System.out.println("Connection closed successfully. Dev is happy");
		} else {
			System.out.println("No connection was previously established");
		}

	}
}
