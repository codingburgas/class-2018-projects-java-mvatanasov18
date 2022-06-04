package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class HomeController implements ActionController {
	@FXML
	private Label welcome;
	@FXML
	private ToolBar navbar;

	public void setText(String text) {
		welcome.setText("Welcome "+text);
	}
	
	public void addButton(String name) {
		Button btn=new Button(name);
		btn.setOnAction(new EventHandler() {


			@Override
			public void handle(Event arg0) {
				System.out.println("calendar");
				
			}
		});
		navbar.getItems().add(btn);
	}
	
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
