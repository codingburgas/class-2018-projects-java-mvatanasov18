package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.AddController;
import controllers.Session;
import controllers.TeamsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class TeamsView  extends Navbar{

private TeamsController tc;
	public TeamsView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Teams.fxml"));
			
			Parent root = loader.load();
			
			tc=loader.getController();
			
			Navbar n=new Navbar();
			ToolBar tb=tc.getNavbar();
			 if( Session.getRole().equals("principal")) {
				
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("View Tasks", tb);
				n.addButton("Calendar", tb);
			}else if( Session.getRole().equals("student") || Session.getRole().equals("teacher")) {
				
				n.addButton("Logout", tb);
				n.addButton("View Tasks", tb);
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
