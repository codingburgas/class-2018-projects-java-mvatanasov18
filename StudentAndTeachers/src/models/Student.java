package models;

public class Student {

	private int studentId;
	private String firstName;
	private String lastName;
	private String username;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Student(int studentId, String firstName, String lastName, String username) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Id=" + studentId + ", name =" + firstName + " " + lastName + ", username="
				+ username ;
	}
	
	
	
}
