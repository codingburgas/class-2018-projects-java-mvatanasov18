package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//findUserByUsernameAndPassword - 

public class Query {

	public static String findDuplicateUsername(String username) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT username FROM Users WHERE username=?";

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			String user = "";
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

	public static int getUserIdFromUsername(String username) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT userId,username FROM Users WHERE username=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int id = resultSet.getInt(1);

			model.closeConnection();
			return id;
		} catch (Exception e) {
			System.out.println("Error when checking user");
			e.printStackTrace();
		}

		return 0;
	}

	public static int insertUser(String username, String password, String firstName, String lastName, String address,
			String phone) {

		try {

			ConnectionModel model = new ConnectionModel();

			String query = "EXEC	insertUser" + "		@Username = ? ," + "		@FirstName = ?"
					+ ",	@LastName = ?," + "		@Password = ? ," + "		@Address = ? ," + "		@Phone = ?";

			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.setString(6, phone);

			System.out.println(query);

			int rows = ps.executeUpdate();

			System.out.println("Affected Arows: " + rows);

			int id = getUserIdFromUsername(username);

			model.closeConnection();
			System.out.println(id);
			return id;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

	public static void insertPrincipal(int userId, String schoolName) {

		try {
			ConnectionModel model = new ConnectionModel();

			String query = "INSERT INTO Principals(schoolName,isVerified,userId) " + "VALUES(?,0,?);";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, schoolName);
			ps.setInt(2, userId);

			int rows = ps.executeUpdate();

			System.out.println("Affected rows: " + rows);

			model.closeConnection();

		} catch (Exception e) {
			System.out.println("chupq se ");
			e.printStackTrace();

		}

	}

	public static String selectPasswordByUsername(String username) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "EXEC returnPassword @username=?";

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			String password = "";
			resultSet.next();
			password = resultSet.getNString(2);

			model.closeConnection();

			return password;

		} catch (Exception e) {
			System.out.println("Error when checking user");
			e.printStackTrace();
			return "a";
		}
	}
	
	
	public static boolean isPrincipal(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT userId FROM Principals WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int userid = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(userid);
			return true;
		} catch (Exception e) {
			System.out.println("No principal with id: "+id);
			
		}
		
		
		return false;
	}

	public static boolean isStudent(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT userId FROM Students WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int userid = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(userid);
			return true;
		} catch (Exception e) {
			System.out.println("No student with id: "+id);
			
		}
		return false;
	}

	public static boolean isTeacher(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT userId FROM Teachers WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int userid = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(userid);
			return true;
		} catch (Exception e) {
			System.out.println("No teacher with id: "+id);
			
		}
		return false;
	}
	
	public static String getName(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT firstName,userId FROM Users WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			String firstName= resultSet.getString(1);

			model.closeConnection();
			System.out.println(firstName);
			return firstName;
		} catch (Exception e) {
			System.out.println("No user");
			
		}
		return "";
	}

}
