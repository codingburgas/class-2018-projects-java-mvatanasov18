package models.tasks;

import models.Student;

public class Task {

	private String dueDate;
	private String title;
	private String description;
	private Student student;
	
	
	
	
	
	
	
	public Task(String dueDate, String title, String description, Student student) {
		this.dueDate = dueDate;
		this.title = title;
		this.description = description;
		this.student = student;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
