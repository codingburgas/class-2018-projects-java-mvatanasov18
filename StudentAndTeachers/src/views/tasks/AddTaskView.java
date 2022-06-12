package views.tasks;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.Add.AddController;
import controllers.tasks.AddTaskController;
import controllers.tasks.TasksController;
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

public class AddTaskView  extends Navbar{

private AddTaskController atc;
	public AddTaskView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/tasks/AddTask.fxml"));
			
			Parent root = loader.load();
			
			atc=loader.getController();
			
			HBoxButtonSetter hbs=new HBoxButtonSetter();
			Navbar n=new Navbar();
			ToolBar tb=atc.getNavbar();

		
			if( Session.getRole().equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				

				
			}else if( Session.getRole().equals("student") ){
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);

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
	
}
