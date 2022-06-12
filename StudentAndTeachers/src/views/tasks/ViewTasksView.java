package views.tasks;

import java.io.IOException;
import java.util.Map;

import animatefx.animation.FadeIn;
import controllers.Add.AddController;
import controllers.tasks.AddTaskController;
import controllers.tasks.TasksController;
import controllers.tasks.ViewTasksController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Session;
import models.tasks.Task;
import views.IndexView;
import views.Navbar;

public class ViewTasksView  extends Navbar{

private ViewTasksController vtc;
	public ViewTasksView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/tasks/ViewTasks.fxml"));
			
			Parent root = loader.load();
			
			vtc=loader.getController();
			
			HBoxButtonSetter hbs=new HBoxButtonSetter();
			Navbar n=new Navbar();
			ToolBar tb=vtc.getNavbar();

		
			if( Session.getRole().equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				
				vtc.getPane().setCenter(getTableWithData(vtc.getTasks()));
				
			}else if( Session.getRole().equals("student") ){
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				vtc.getPane().setCenter(getTableWithData(vtc.getTasks()));

			}else if( Session.getRole().equals("teacher")) {
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				
			}
			
			
			stage.setTitle("Students and Teachers");
			
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());
			
			stage.setScene(scene);
			stage.show();
			
			
			
			new FadeIn(root).play();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	private TableView getTableWithData(Map<Integer,Task> tasks) {
		ObservableList<Task> list=FXCollections.observableArrayList();
		
		for(Integer key:tasks.keySet()) {
			list.add(tasks.get(key));
		}
		TableView<Task> table=new TableView<>();
		

		TableColumn taskIdColumn=new TableColumn<Task,Integer>("taskId");
		taskIdColumn.setCellValueFactory(new PropertyValueFactory<Task,Integer>("taskId"));
		
		
		TableColumn titleColumn=new TableColumn<Task,String>("Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("title"));
		
		TableColumn dueDateColumn=new TableColumn<Task,String>("Due Date");
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("dueDate"));
		
		TableColumn descriptionColumn=new TableColumn<Task,String>("Description");
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("description"));
		
		TableColumn studentColumn=new TableColumn<Task,String>("Student");
		studentColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("student"));
		
		table.setItems(list);
		table.getColumns().addAll(
				taskIdColumn,
				titleColumn,
				dueDateColumn,
				descriptionColumn,
				studentColumn);
		
		return table;
	}
	
}
