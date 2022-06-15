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

public class AddTaskModel {

	// getters
	public List<Student> getStudents() {
		return Query.getStudentsBySchoolName(Session.getSchoolName());
	}

	// other methods

	public void addTask(Task t) {
		if (checkTaskData(t)) {
			if (Session.getRole().equalsIgnoreCase("principal")) {
				Query.insertTaskPrincipal(t.getStudent().getStudentId(), t.getDueDate(), t.getDescription(),
						t.getTitle());
			} else if (Session.getRole().equalsIgnoreCase("teacher")) {
				Query.insertTaskTeacher(t.getStudent().getStudentId(), t.getDueDate(), t.getDescription(),
						t.getTitle());
			}
		}
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
