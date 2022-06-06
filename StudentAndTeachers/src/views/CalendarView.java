package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.ActionController;
import controllers.CalendarController;
import controllers.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarView  extends Navbar{

private CalendarController cc;
	public CalendarView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Calendar.fxml"));
			
			Parent root = loader.load();
			
			cc=loader.getController();
			
			if (Session.name != "") {
				System.out.println(Session.name);

				setNavbarOptionsBySessionRole(cc.getNavbar());

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
