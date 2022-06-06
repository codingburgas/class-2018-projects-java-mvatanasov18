package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.LoginController;
import controllers.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView  extends Navbar{
private LoginController lc;
	public LoginView(Stage stage){
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Login.fxml"));
			Parent root = loader.load();
			
			stage.setTitle("Students and Teachers");
			
			lc=loader.getController();
			
			if (Session.name != "") {
				System.out.println(Session.name);

				setNavbarOptionsBySessionRole(lc.getNavbar(),"login");

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
