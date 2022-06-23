package models.tasks;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

import models.Session;
import models.Student;
import models.db.Query;

public class UpdateTaskModel {

	// getters
	public List<Student> getStudents() {
		return Query.getStudentsBySchoolName(Session.getSchoolName());
	}

	// other methods

	public String updateTask(Task t) {
		if (checkTaskData(t)) {
			if (Session.getRole().equalsIgnoreCase("principal")) {
				Query.updateTaskPrincipal(t.getStudent().getStudentId(), t.getDueDate(), t.getDescription(),
						t.getTitle(),t.getTaskId());
			} else if (Session.getRole().equalsIgnoreCase("teacher")) {
				Query.updateTaskTeacher(t.getStudent().getStudentId(), t.getDueDate(), t.getDescription(),
						t.getTitle(),t.getTaskId());
			}
			return "Success";
		}
		return "Error";
	}

	private boolean checkTaskData(Task t) {
		if (t.getStudent() == null) {
			return false;
		}
		if (checkDate(t.getDueDate())) {
			return false;
		}
		if(areBlank(t.getDescription())) {
			return false;
		}
		if(areBlank(t.getTitle())) {
			return false;
		}
		if(Query.getTaskId(t.getTaskId())==0) {
			return false;
		}
		if(Query.checkTaskId(t.getTaskId())==0) {
			System.out.println("vurnah 0");
			return false;
		}
		return true;
	}

	public static boolean checkDate(Date d) {

		if (d == null) {
			return true;
		}
		return false;
	}
	
	private boolean areBlank(String text) {
		return text.isBlank();

	}
}
