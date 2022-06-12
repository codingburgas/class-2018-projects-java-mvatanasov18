package controllers.Add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;
import views.RegisterView;
import views.Add.CreateStudentView;
import views.Add.CreateTeacherView;

public class AddController {

	@FXML
	private ToolBar navbar;

	public ToolBar getNavbar() {
		return navbar;
	}

	public void createStudentAccount(ActionEvent event) {
		System.out.println("create student");
		new CreateStudentView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}

	public void createTeacherAccount(ActionEvent event) {
		System.out.println("create teacher");
		new CreateTeacherView((Stage) ((Node) event.getSource()).getScene().getWindow());
	}

}
