package models;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.db.Query;

public class LoginModel {
	
	private String username;
	private String password;
	
	public LoginModel(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String[] checkLogin() {
		if(username.isBlank() || password.isBlank()) {
			return new String[]{"Enter data",""};
		}
		
		
		if(doesUserExist()) {
			if(checkPassword()) {
				System.out.println("Login was successful");
				int id=Query.getUserIdFromUsername(username);
				Session.setSchoolName(Query.getSchoolNameByUsername(username));
				// Session.setUserName(username);
				return new String[]{seeRole(id),Query.getNameById(id)};
			}
		}
		
		return new String[]{"not a user",""};
	}
	
	private boolean doesUserExist() {
		
		String result=Query.findDuplicateUsername(username);
		
		if(result.equals(username)) {
			return true;
		}
		return false;
	}
	
	private boolean checkPassword() {
		String result=Query.selectPasswordByUsername(username);
		
		if(result.equals(password)) {
			return true;
		}
		return false;
	}
	
	private String seeRole(int id) {
		if(Query.isPrincipal(id)) {
			
			
			return "principal";
		}
		else if(Query.isStudent(id)) {
			
			return "student";
		}
		else if(Query.isTeacher(id)) {
			
			return "teacher";
		}
		
		return "";
	}
	
	public boolean isAuth() {
		
		if(Query.getIsVerified()!=0) {
			return true;
		}
		
		return false;
	}
	
}
