package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.CalendarController;
import controllers.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class CalendarView  extends Navbar{

private CalendarController cc;
	public CalendarView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Calendar.fxml"));
			
			Parent root = loader.load();
			
			cc=loader.getController();
			
			Navbar n=new Navbar();
			ToolBar tb=cc.getNavbar();
			 if( Session.role.equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("View Tasks", tb);
			}else if( Session.role.equals("student") || Session.role.equals("teacher")) {
				
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("View Tasks", tb);
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
