package views.tasks;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.Add.AddController;
import controllers.tasks.AddTaskController;
import controllers.tasks.TasksController;
import controllers.tasks.UpdateTaskController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Session;
import views.IndexView;
import views.Navbar;

public class UpdateTaskView  extends Navbar{

private UpdateTaskController utc;
	public UpdateTaskView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/tasks/UpdateTask.fxml"));
			
			Parent root = loader.load();
			
			utc=loader.getController();
			
			HBoxButtonSetter hbs=new HBoxButtonSetter();
			Navbar n=new Navbar();
			ToolBar tb=utc.getNavbar();

		
			if( Session.getRole().equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				n.addButton("Tasks", tb);

				
			}else if( Session.getRole().equals("teacher")) {
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				n.addButton("Tasks", tb);
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
	
}
