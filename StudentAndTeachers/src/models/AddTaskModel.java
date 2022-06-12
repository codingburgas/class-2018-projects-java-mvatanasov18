package models;

import java.util.List;

import controllers.Session;

public class AddTaskModel {

	// getters
	public List<Student> getStudents() {
		return Query.getStudentsBySchoolName(Session.getSchoolName());
	}

	// other methods

	public void addTask(Task t) {

		if (Session.getRole().equalsIgnoreCase("principal")) {
			Query.insertTaskPrincipal(
					t.getStudent().getStudentId(),
					t.getDueDate(), 
					t.getDescription(),
					t.getTitle());
		}else if(Session.getRole().equalsIgnoreCase("teacher")) {
			Query.insertTaskTeacher(
					t.getStudent().getStudentId(),
					t.getDueDate(), 
					t.getDescription(),
					t.getTitle());
		}
	}
}
