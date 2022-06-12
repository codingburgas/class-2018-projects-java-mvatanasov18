package models.tasks;

import java.util.Map;

import models.db.Query;

public class ViewTasksModel {

	
	public Map<Integer,Task> getTasks(){
		return Query.getTasksBySchoolName();
	}
	
}
