package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.RegisterController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.Session;

public class RegisterView {
	private RegisterController rc;
	
	public RegisterView (Stage stage){
		//System.out.println("In register");
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/fxml/Register.fxml"));
			Parent root=loader.load();
			stage.setTitle("Students and Teachers");
			
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());
			rc=loader.getController();
			Navbar n=new Navbar();
			ToolBar tb=rc.getNavbar();
			if (Session.getName().equals("")) {
				
				
				
				
				n.addButton("Home", tb);
				n.addButton("Login", tb);
				
			}
			
			stage.setScene(scene);
			stage.show();
			
			
			
			new FadeIn(root).play();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
