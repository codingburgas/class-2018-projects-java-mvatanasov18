package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.CreateStudentModel;
import models.RegisterModel;
import views.IndexView;
import views.LoginView;
import views.RegisterView;

public class CreateStudentController {

	@FXML
	private ToolBar navbar;
	
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField address;
	@FXML
	private TextField confirmPassword;
	@FXML
	private TextField phone;
	@FXML
	private TextField parentEmail;
	@FXML
	private TextField parentPhone;
	@FXML
	private TextField parentAddress;
	@FXML
	private Label errorBlock;
	
	public ToolBar getNavbar() {
		return navbar;
	}
	
	public void submit(ActionEvent event) {
		System.out.println("submit");

		String tempUsername=username.getText().toString();
		String tempPassword=password.getText().toString();
		String tempFirstName=firstName.getText().toString();
		String tempLastName=lastName.getText().toString();
		String tempAddress=address.getText().toString();
		String tempConfirmPassword=confirmPassword.getText().toString();
		String tempPhone=phone.getText().toString();
		String tempParentEmail=parentEmail.getText().toString();
		String tempParentPhone=parentPhone.getText().toString();
		String tempParentAddress=parentAddress.getText().toString();
		
		String txt=new CreateStudentModel(tempUsername, tempPassword, tempFirstName,
				tempLastName, tempAddress, tempConfirmPassword,
				tempPhone, tempParentEmail, 
				tempParentPhone, tempParentAddress).checkStudentRegister();
		
		errorBlock.setText(txt);
		
	}

}
