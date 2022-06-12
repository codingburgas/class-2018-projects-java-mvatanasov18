package views.tasks;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.Add.AddController;
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

public class TasksView  extends Navbar{

private TasksController tc;
	public TasksView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/tasks/Tasks.fxml"));
			
			Parent root = loader.load();
			
			tc=loader.getController();
			
			HBoxButtonSetter hbs=new HBoxButtonSetter();
			Navbar n=new Navbar();
			ToolBar tb=tc.getNavbar();
			HBox box1=tc.getFirstHBox();
			HBox box2=tc.getSecondHBox();
			Label l = new Label("");
			l.setMinSize(170, 70);
			Label l1=new Label("");
			l1.setMinSize(170, 70);
		
			if( Session.getRole().equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				
				hbs.addButtonToHBox("Add task", box1);
				
				box1.getChildren().add(l1);
				hbs.addButtonToHBox("View tasks", box1);
				
				hbs.addButtonToHBox("Delete task", box2);
				box2.getChildren().add(l);
				hbs.addButtonToHBox("Update task", box2);
				
			}else if( Session.getRole().equals("student") ){
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				
				hbs.addButtonToHBox("View tasks", box1);
			}else if( Session.getRole().equals("teacher")) {
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("Calendar", tb);
				
				hbs.addButtonToHBox("Add task", box1);
				box1.getChildren().add(l);
				hbs.addButtonToHBox("View tasks", box1);
				
				hbs.addButtonToHBox("Delete task", box2);
				box2.getChildren().add(l1);
				hbs.addButtonToHBox("Update task", box2);
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
