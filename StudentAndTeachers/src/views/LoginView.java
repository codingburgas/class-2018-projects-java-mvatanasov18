package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.LoginController;
import controllers.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class LoginView  extends Navbar{
private LoginController lc;
	public LoginView(Stage stage){
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Login.fxml"));
			Parent root = loader.load();
			
			stage.setTitle("Students and Teachers");
			
			lc=loader.getController();
			
			Navbar n=new Navbar();
			ToolBar tb=lc.getNavbar();
			if (Session.getName().equals("")) {
				
				
				
				
				n.addButton("Home", tb);
				n.addButton("Register", tb);
				
			}
			
			
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
