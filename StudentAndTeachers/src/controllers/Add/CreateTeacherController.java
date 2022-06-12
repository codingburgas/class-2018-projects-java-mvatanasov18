package controllers.Add;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.RegisterModel;
import models.Add.CreateStudentModel;
import models.Add.CreateTeacherModel;
import views.IndexView;
import views.LoginView;
import views.RegisterView;
import views.Add.CreateTeacherView;

public class CreateTeacherController {

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
	private TextField subjectName;
	@FXML
	private Label errorBlock;
	
	public ToolBar getNavbar() {
		return navbar;
	}
	
	public Label getBlock() {
		return errorBlock;
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
		String tempSubjectName=subjectName.getText().toString();
		
		String txt=new CreateTeacherModel(tempUsername, tempPassword, tempFirstName,
				tempLastName, tempAddress, tempConfirmPassword,
				tempPhone,tempSubjectName).checkTeacherRegister();
		
		if(txt.startsWith("Successfully")) {
			new CreateTeacherView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}
		
		errorBlock.setText(txt);
		
	}

}
