package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class AddController implements ActionController {

	
	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}
	
	
	@Override
	public void home(ActionEvent event) {
		
		System.out.println("Home");
		new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());

	}

	@Override
	public void logIn(ActionEvent event) {
		System.out.println("logIn");
        new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
		
	}

	@Override
	public void register(ActionEvent event) {
		System.out.println("Register");
		new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}
	
	
}
