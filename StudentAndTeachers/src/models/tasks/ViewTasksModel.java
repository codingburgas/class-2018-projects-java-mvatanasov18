package models.tasks;

import java.sql.PreparedStatement;
import java.util.Map;

import models.db.ConnectionModel;
import models.db.Query;

public class ViewTasksModel {

	
	public Map<Integer,Task> getTasks(){
		return Query.getTasksBySchoolName();
	}
	
	public int deleteTaskById(int taskId) {
		try {
			ConnectionModel model=new ConnectionModel();
			
			String query="DELETE FROM Tasks WHERE taskId=?";
			PreparedStatement ps=model.createPrepareStatement(query);
			ps.setInt(1, taskId);
			
			int rows=ps.executeUpdate();
			model.closeConnection();
			return rows;
		}catch(Exception e) {
			System.out.println("Cannot delete task with id: "+taskId);
			e.printStackTrace();
			return 0;
		}
	}
	
}
