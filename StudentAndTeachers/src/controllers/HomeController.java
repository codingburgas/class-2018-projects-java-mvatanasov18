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
import models.Session;
import views.CalendarView;
import views.IndexView;
import views.LoginView;
import views.RegisterView;
import views.tasks.TasksView;

public class HomeController {
	@FXML
	private Label welcome;
	@FXML
	private ToolBar navbar;

	public void setText(String text) {
		welcome.setText("Welcome "+text);
	}
	
	public ToolBar getNavbar() {
		return navbar;
	}
	
	public void displayUpcomingTasks(ActionEvent event) {
		if(Session.isLoggedIn()) {
			new TasksView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}else {
			new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}
	}


}
