package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.AuthController;
import controllers.HomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.Session;

public class AuthView extends Navbar {
	private AuthController ac;

	public AuthView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/NotAuth.fxml"));

			Parent root = loader.load();
			ac = loader.getController();
			stage.setTitle("Students and Teachers");
			Navbar n=new Navbar();
			ToolBar tb=ac.getNavbar();
			
				n.addButton("Login", tb);
				n.addButton("Register", tb);


			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();

			new FadeIn(root).play();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
