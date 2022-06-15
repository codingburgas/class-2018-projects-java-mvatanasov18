package models.tasks;

import java.sql.PreparedStatement;
import java.util.Map;

import models.db.ConnectionModel;
import models.db.Query;

public class ViewTasksModel {

	
	public Map<Integer,Task> getTasks(){
		return Query.getTasksBySchoolName();
	}
	
}
