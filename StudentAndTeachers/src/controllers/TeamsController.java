package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class TeamsController {

	
	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}
	
}
