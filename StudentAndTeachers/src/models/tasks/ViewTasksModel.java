package models.tasks;

import java.sql.PreparedStatement;
import java.util.Map;

import models.Session;
import models.db.ConnectionModel;
import models.db.Query;

public class ViewTasksModel {

	
	public Map<Integer,Task> getTasks(){
		if(Session.getRole().equals("principal")) {
		return Query.getTasksBySchoolName();
		}
		else if(Session.getRole().equals("teacher")) {
			return Query.getTasksBySchoolName();
		}
		return Query.getTasksByUsername();
	}
	
}
