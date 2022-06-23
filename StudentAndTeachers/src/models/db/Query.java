package models.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Session;
import models.Student;
import models.tasks.Task;

//getStudentsBySchoolName
//getSchoolNameByUsername
//findDuplicateUsername
//getUserIdFromUsername
//selectPasswordByUsername
//getNameById
//insertUser
//insertPrincipal
//insertTeacher
//insertStudent
//insertTaskPrincipal
//isPrincipal
//isStudent
//isTeacher

public class Query {
////////////////// GET QUERIES

	public static List<Student> getStudentsBySchoolName(String schoolName) {

		try {
			List<Student> list = new ArrayList<>();
			ConnectionModel model = new ConnectionModel();

			String query = "SELECT " + "Users.username, " + "firstName, " + "lastName , " + "Students.studentId "
					+ "FROM Users " + "INNER JOIN Students ON Users.userId=Students.userId AND Users.schoolName=?";

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, schoolName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt("studentId"), rs.getNString("firstName"), rs.getNString("lastName"),
						rs.getNString("username")));
			}

			model.closeConnection();
			return list;
		} catch (Exception e) {
			System.out.println("Error when retrieving students");
		}

		return null;
	}

	public static String getSchoolNameByUsername(String username) {
		try {
			ConnectionModel model = new ConnectionModel();
			String query = "SELECT schoolName FROM Users WHERE username=?";
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setString(1, username);

			ResultSet resultSet = ps.executeQuery();
			String schoolName = "";
			while (resultSet.next()) {
				schoolName = resultSet.getNString(1);
			}
			model.closeConnection();

			return schoolName;
		} catch (Exception e) {
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
			String firstName = resultSet.getString(1);

			model.closeConnection();
			System.out.println(firstName);
			return firstName;
		} catch (Exception e) {
			System.out.println("No user");

		}
		return "";
	}

	public static Map<Integer, Task> getTasksBySchoolName() {
		try {
			String query = "SELECT [Tasks].[taskId]" + "      ,[Tasks].[teacherId]" + "      ,[Tasks].[dueDate]"
					+ "      ,[Tasks].[description]" + "      ,[Tasks].[title]" + "      ,Principals.[principalId]"
					+ "	  ,Users.username" + "	  ,Students.studentId" + "  FROM [StudentsAndTeachers].[dbo].[Tasks]"
					+ "  INNER JOIN Principals ON Principals.principalId=Tasks.principalId "
					+ "  Inner join Users ON Users.userId=Principals.userId AND Users.schoolName=? "
					+ "  Inner Join Students ON Tasks.studentId=Students.studentId ";

			ConnectionModel model = new ConnectionModel();
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setNString(1, Session.getSchoolName());
			Map<Integer, Task> tasks = new HashMap<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Task t = new Task(rs.getDate("dueDate"), rs.getNString("title"), rs.getString("description"),
						getStudentByStudentId(rs.getInt("studentId")));
				t.setTaskId(rs.getInt("taskId"));
				tasks.put(rs.getInt("taskId"), t);
			}
			model.closeConnection();
			return tasks;

		} catch (Exception e) {
			System.out.println("Error when retrieving tasks");
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static Map<Integer, Task> getTasksByUsername() {
		try {
			String query = "SELECT "
					+ "[Tasks].[taskId] "
					+ ",[Tasks].[teacherId] "
					+ ",[Tasks].[dueDate] "
					+ ",[Tasks].[description] "
					+ ",[Tasks].[title]  "
					+ ",Principals.[principalId] "
					+ ",Users.username "
					+ ",Students.studentId "
					+ "FROM "
					+ "[StudentsAndTeachers].[dbo].[Tasks] "
					+ "INNER JOIN Principals ON Principals.principalId=Tasks.principalId "
					+ "Inner Join Students ON Tasks.studentId=Students.studentId "
					+ "Inner join Users ON Users.userId=Students.userId AND Users.username=?";
			ConnectionModel model = new ConnectionModel();
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setNString(1, Session.getUsername());
			Map<Integer, Task> tasks = new HashMap<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Task t = new Task(rs.getDate("dueDate"), rs.getNString("title"), rs.getString("description"),
						getStudentByStudentId(rs.getInt("studentId")));
				t.setTaskId(rs.getInt("taskId"));
				tasks.put(rs.getInt("taskId"), t);
			}
			model.closeConnection();
			return tasks;

		} catch (Exception e) {
			System.out.println("Error when retrieving tasks");
			e.printStackTrace();
		}

		return null;
	}

	public static int checkTaskId(int taskId) {
		try {
			
			String query="EXEC checkTaskId @taskId=? , @schoolName=?";
			ConnectionModel model=new ConnectionModel();
			PreparedStatement ps=model.createPrepareStatement(query);
			ps.setInt(1,taskId );
			ps.setString(2, Session.getSchoolName());
			ResultSet rs=ps.executeQuery();
			int temp=0;
			while(rs.next()) {
				temp=rs.getInt("result");
			}
			model.closeConnection();
			return temp;
			
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static Student getStudentByStudentId(int studentId) {
		try {

			String query = "SELECT [studentId]," + "Users.firstName," + "Users.lastName," + "Users.username"
					+ "  FROM [StudentsAndTeachers].[dbo].[Students]"
					+ "  INNER JOIN Users ON Users.userId=Students.userId AND studentId=?";
			ConnectionModel model = new ConnectionModel();
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();
			Student s=null;
			while (rs.next()) {
				s=new Student(rs.getInt("studentId"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("username"));
			}
			model.closeConnection();
			return s;
		} catch (Exception e) {
			System.out.println("Error when retrieving data from Students id= " + studentId);
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int getIsVerified() {
		try {
			ConnectionModel model=new ConnectionModel();
			String query="SELECT isVerified FROM Principals INNER JOIN Users ON username=? AND Users.userId=Principals.userId";
			
			PreparedStatement ps=model.createPrepareStatement(query);
			ps.setString(1,Session.getUsername());
			ResultSet rs=ps.executeQuery();
			int id=0;
			while(rs.next()) {
				id=rs.getInt("isVerified");
			}
			model.closeConnection();
			return id;
		}catch(Exception e) {
			
		}
		return 0;
	}
	

	public static int getTaskId(int taskId) {
		try {
			
			ConnectionModel model=new ConnectionModel();
			String query="SELECT taskId FROM Tasks WHERE taskId=?";
			PreparedStatement ps=model.createPrepareStatement(query);
			ps.setInt(1, taskId);
			ResultSet rs=ps.executeQuery();
			int id=0;
			while(rs.next()) {
				id=rs.getInt("taskId");
			}
			model.closeConnection();
			return id;
			
		}catch(Exception e) {
			return 0;
		}
	}
	
	///////////////////// INSERT ////////////////
	public static int insertUser(String username, String password, String firstName, String lastName, String address,
			String phone, String schoolName) {

		try {

			ConnectionModel model = new ConnectionModel();

			String query = "EXEC	insertUser" + "		@Username = ? ," + "		@FirstName = ?"
					+ ",	@LastName = ?," + "		@Password = ? ," + "		@Address = ? ,"
					+ "		@Phone = ?, @SchoolName=?";

			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.setString(6, phone);
			ps.setString(7, schoolName);

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

	public static void insertStudent(int userId, String parentPhone, String parentEmail, String parentAddress) {

		try {
			ConnectionModel model = new ConnectionModel();

			String query = "EXEC insertStudent @parentPhone=? " + ", @parentAddress=? , @parentEmail=? , @userId=?  ";
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

	public static void insertTaskPrincipal(int studentId, Date dueDate, String description, String title) {
		try {
			String query = "INSERT INTO Tasks(" + "principalId," + "studentId," + "dueDate," + "description,"
					+ "title) " + "VALUES(?,?,?,?,?)";

			ConnectionModel model = new ConnectionModel();

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setInt(1, Session.getId());
			ps.setInt(2, studentId);
			ps.setDate(3, dueDate);
			ps.setNString(4, description);
			ps.setNString(5, title);

			int rows = ps.executeUpdate();
			System.out.println("Affected rows: " + rows);
			model.closeConnection();
		} catch (Exception e) {
			System.out.println("Error when inserting task");
			e.printStackTrace();
		}
	}

	public static void insertTaskTeacher(int studentId, Date dueDate, String description, String title) {
		try {
			String query = "INSERT INTO Tasks(" + "teacherId," + "studentId," + "dueDate," + "description," + "title) "
					+ "VALUES(?,?,?,?,?)";

			ConnectionModel model = new ConnectionModel();

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setInt(1, Session.getId());
			ps.setInt(2, studentId);
			ps.setDate(3, dueDate);
			ps.setNString(4, description);
			ps.setNString(5, title);

			int rows = ps.executeUpdate();
			System.out.println("Affected rows: " + rows);
			model.closeConnection();
		} catch (Exception e) {
			System.out.println("Error when inserting task");
			e.printStackTrace();
		}
	}
	
	
	
	////////////UPDATE
	public static void updateTaskPrincipal(int studentId, Date dueDate, String description, String title,int taskId) {
		try {
			String query = "UPDATE Tasks SET "
					+ " principalId=? , "
					+ " studentId=? , "
					+ " dueDate=? , "
					+ " description=? ,"
					+ " title=? "
					+ " WHERE taskId=?";

			ConnectionModel model = new ConnectionModel();
			
			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setInt(1, Session.getId());
			ps.setInt(2, studentId);
			ps.setDate(3, dueDate);
			ps.setNString(4, description);
			ps.setNString(5, title);
			ps.setInt(6, taskId);
			int rows = ps.executeUpdate();
			System.out.println("Affected rows: " + rows);
			model.closeConnection();
		} catch (Exception e) {
			System.out.println("Error when updating task");
			e.printStackTrace();
		}
	}
	
	public static void updateTaskTeacher(int studentId, Date dueDate, String description, String title,int taskId) {
		try {
			String query = "UPDATE Tasks SET  principalId=? , studentId=?  , dueDate=? , description=? ,title=?  WHERE  taskId=?";

			ConnectionModel model = new ConnectionModel();

			PreparedStatement ps = model.createPrepareStatement(query);
			ps.setInt(1, Session.getId());
			ps.setInt(2, studentId);
			ps.setDate(3, dueDate);
			ps.setNString(4, description);
			ps.setNString(5, title);
			ps.setInt(6, taskId);
			int rows = ps.executeUpdate();
			System.out.println("Affected rows: " + rows);
			model.closeConnection();
		} catch (Exception e) {
			System.out.println("Error when updating task");
			e.printStackTrace();
		}
	}
	
	/////////// CHECKING ROLE
	public static boolean isPrincipal(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT principalId FROM Principals WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int principalId = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(principalId);
			Session.setId(principalId);
			return true;
		} catch (Exception e) {
			System.out.println("No principal with id: " + id);

		}

		return false;
	}

	public static boolean isStudent(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT studentId FROM Students WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int studentId = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(studentId);
			Session.setId(studentId);
			return true;
		} catch (Exception e) {
			System.out.println("No student with id: " + id);

		}
		return false;
	}

	public static boolean isTeacher(int id) {
		try {

			ConnectionModel model = new ConnectionModel();

			String query = "SELECT teacherId FROM Teachers WHERE userId=?";
			PreparedStatement ps = model.createPrepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			int teacherId = resultSet.getInt(1);

			model.closeConnection();
			System.out.println(teacherId);
			Session.setId(teacherId);
			return true;
		} catch (Exception e) {
			System.out.println("No teacher with id: " + id);

		}
		return false;
	}

}
