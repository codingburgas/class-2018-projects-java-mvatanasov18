package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.CreateStudentController;
import controllers.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateStudentView  extends Navbar{

private CreateStudentController csc;
	public CreateStudentView(Stage stage){
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/CreateStudent.fxml"));
			
			Parent root = loader.load();
			
			csc=loader.getController();
			
			if (Session.name != "") {
				setNavbarOptionsBySessionRole(csc.getNavbar(),"");

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
