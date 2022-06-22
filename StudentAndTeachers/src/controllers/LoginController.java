package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.LoginModel;
import models.Session;
import views.AuthView;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class LoginController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label errorMessage;
	@FXML
	private Label welcome;
	@FXML
	private ToolBar navbar;
	public ToolBar getNavbar() {
		return navbar;
	}
	
	public void submit(ActionEvent event) {
		System.out.println("Submit");
		
		String tempUsername=username.getText().toString();
		String tempPassword=password.getText().toString();
		
		LoginModel lm=new LoginModel(tempUsername,tempPassword);
		String[] message=lm.checkLogin();
		if(message[0].equals("student") ||
				message[0].equals("teacher")||
				message[0].equals("principal")) {
			
			Session.setLoggedIn(true);
			Session.setName(message[1]);
			Session.setRole(message[0]);
			
			if(lm.isAuth()) {
			
			new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
			}else {
				//display message that the user is not authenticated
				new AuthView((Stage) ((Node) event.getSource()).getScene().getWindow());
			}
			
		}else {
		errorMessage.setText(message[0]+message[1]);
		
		}
	}
}
