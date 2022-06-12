package controllers.teams;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class TeamsController {

	
	@FXML
	private ToolBar navbar;
	@FXML
	private HBox firstHBox;
	@FXML
	private HBox secondHBox;

	public ToolBar getNavbar() {
		return navbar;
	}

	public HBox getFirstHBox() {
		return firstHBox;
	}

	public HBox getSecondHBox() {
		return secondHBox;
	}
	
}
