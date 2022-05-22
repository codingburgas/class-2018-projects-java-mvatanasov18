package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Query;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class HomeController implements ActionController {

	public void displayUpcomingTasks(ActionEvent event) {
		System.out.println("displayUpcomingTasks");
	}

	@Override
	public void home(ActionEvent event) {
		System.out.println("Home");
		IndexView home = new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}

	@Override
	public void logIn(ActionEvent event) {
		System.out.println("logIn");
		LoginView login = new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
		
	}

	@Override
	public void register(ActionEvent event) {
		System.out.println("Register");
		RegisterView login = new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}
}
