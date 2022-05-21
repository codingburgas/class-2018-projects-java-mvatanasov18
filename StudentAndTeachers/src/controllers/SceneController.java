package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Query;
import views.Index;
import views.Login;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void checkConnection() {
		new Query().testQuery();
	}
	
	public void home(ActionEvent event) {
		System.out.println("Home");
		Index home =new Index((Stage)((Node)event.getSource()).getScene().getWindow());
	}
	public void logIn(ActionEvent event) {
		System.out.println("logIn");
		Login home =new Login((Stage)((Node)event.getSource()).getScene().getWindow());
	}
	public void register(ActionEvent event) {
		System.out.println("register");
	}
	public void displayUpcomingTasks(ActionEvent event) {
		System.out.println("displayUpcomingTasks");
	}
}
