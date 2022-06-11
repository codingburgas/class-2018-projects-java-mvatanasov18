package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.RegisterController;
import controllers.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class RegisterView {
	private RegisterController rc;
	
	public RegisterView (Stage stage){
		//System.out.println("In register");
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/Register.fxml"));
			Parent root=loader.load();
			stage.setTitle("Students and Teachers");
			
			
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());
			rc=loader.getController();
			Navbar n=new Navbar();
			ToolBar tb=rc.getNavbar();
			if (Session.name.equals("")) {
				
				
				
				
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
