package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Query {
////////////////// GET COLUMNS 
	
	
	
	public static String getSchoolNameByUsername(String username) {
		try {
			ConnectionModel model = new ConnectionModel();
			String query="SELECT schoolName FROM Users WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			String schoolName = "";
			while (resultSet.next()) {
				schoolName = resultSet.getNString(1);
			}
			model.closeConnection();

			return schoolName;
		}catch(Exception e) {
			System.out.println("Error when retrieving school name");
			return " ";
		}
		
	}
	
	
	
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
	
	
	public static String getNameById(int id) {
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
	
	
	
	/////////////////////     INSERT     ////////////////
	public static int insertUser(String username, String password, String firstName, String lastName, String address,
			String phone,String schoolName) {

		try {

			ConnectionModel model = new ConnectionModel();

			String query = "EXEC	insertUser" + "		@Username = ? ," + "		@FirstName = ?"
					+ ",	@LastName = ?," + "		@Password = ? ," + "		@Address = ? ," + "		@Phone = ?, @SchoolName=?";

			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.setString(6, phone);
			ps.setString(7, schoolName);
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

	public static void insertPrincipal(int userId) {

		try {
			ConnectionModel model = new ConnectionModel();

			String query = "INSERT INTO Principals(isVerified,userId) " + "VALUES(0,?);";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, userId);

			int rows = ps.executeUpdate();

			System.out.println("Affected rows: " + rows);

			model.closeConnection();

		} catch (Exception e) {
			System.out.println("Error when inserting principal");
			e.printStackTrace();

		}

	}
	
	public static void insertTeacher(int userId, String subjectName) {

		try {
			ConnectionModel model = new ConnectionModel();

			String query = "INSERT INTO Teachers(subjectName,userId) " + "VALUES(?,?);";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, subjectName);
			ps.setInt(2, userId);

			int rows = ps.executeUpdate();

			System.out.println("Affected rows: " + rows);

			model.closeConnection();

		} catch (Exception e) {
			System.out.println("Error when inserting teacher");
			e.printStackTrace();

		}

	}
	
	public static void insertStudent(int userId, String parentPhone,String parentEmail,String parentAddress) {

		try {
			ConnectionModel model = new ConnectionModel();

			String query = "EXEC insertStudent @parentPhone=? "
					+ ", @parentAddress=? , @parentEmail=? , @userId=?  ";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, parentPhone);
			ps.setString(2, parentEmail);
			ps.setString(3, parentAddress);
			ps.setInt(4, userId);

			int rows = ps.executeUpdate();

			System.out.println("Affected rows: " + rows);

			model.closeConnection();

		} catch (Exception e) {
			System.out.println("Error when inserting student");
			e.printStackTrace();

		}

	}
	
	
	/////////// CHECKING ROLE
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


}
