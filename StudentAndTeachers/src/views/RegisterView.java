package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterView {
	public RegisterView (Stage stage){
		//System.out.println("In register");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/Register.fxml"));
			
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
