package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.AddController;
import controllers.Session;
import controllers.TeamsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeamsView  extends Navbar{

private TeamsController tc;
	public TeamsView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Teams.fxml"));
			
			Parent root = loader.load();
			
			tc=loader.getController();
			
			if (Session.name != "") {
				setNavbarOptionsBySessionRole(tc.getNavbar(),"teams");

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
