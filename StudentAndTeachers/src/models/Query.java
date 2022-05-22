package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {

	public static ResultSet findUserByUsernameAndPassword(String username, String password) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT username,password " + "FROM Users" + " WHERE username=? AND password=?";

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet resultSet = ps.executeQuery();
			model.closeConnection();

			return resultSet;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String findUserByUsername(String username) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT username " + "FROM Users" + " WHERE username=?";

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			String user="";
			while (resultSet.next()) {
				user = resultSet.getNString(1);
			}
			model.closeConnection();

			return user;

		} catch (Exception e) {
			System.out.println("Error when checking user");
			e.printStackTrace();
			return "a";
		}

	}

	public static int insertUser(String username, String password, String firstName, String lastName, String address) {

		try {

			ConnectionModel model = new ConnectionModel();

			String query = "INSERT INTO Users(username,firstName,lastName,password,address) " + "VALUES(?,?,?, "
					+ " CONVERT(varbinary(max),HASHBYTES( 'SHA2_256',?) ,2)"
					+ " ,   CONVERT(varbinary(max),HASHBYTES( 'SHA2_256',?) ,2))";

			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, address);

			ps.executeUpdate();
			int rows = ps.getUpdateCount();
			model.closeConnection();
			return rows;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

}
