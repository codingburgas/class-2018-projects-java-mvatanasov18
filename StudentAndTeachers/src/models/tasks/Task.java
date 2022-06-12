package models.tasks;

import java.sql.Date;

import models.Student;

public class Task {
	private int taskId;
	private Date dueDate;
	private String title;
	private String description;
	private Student student;
	
	
	
	
	
	
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Task(Date date, String title, String description, Student student) {
		this.dueDate = date;
		this.title = title;
		this.description = description;
		this.student = student;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
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
