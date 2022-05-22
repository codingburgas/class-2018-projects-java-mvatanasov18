package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.LoginModel;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class LoginController implements ActionController{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label errorMessage;
	@FXML
	private Label welcome;
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
	
	
	public void submit(ActionEvent event) {
		System.out.println("Submit");
		
		String tempUsername=username.getText().toString();
		String tempPassword=password.getText().toString();
		
		LoginModel lm=new LoginModel(tempUsername,tempPassword);
		String[] message=lm.checkLogin();
		if(message[0].equals("student") || message[0].equals("teacher")|| message[0].equals("principal")) {
			IndexView home = new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow(),message[1]);
			System.out.println("tuk sum");
		}
		errorMessage.setText(message[0]+message[1]);
		
		
	}
}
