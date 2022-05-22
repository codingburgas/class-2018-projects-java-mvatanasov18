package models;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginModel {
	
	private String username;
	private String password;
	
	public LoginModel(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String[] checkLogin() {
		if(doesUserExist()) {
			if(checkPassword()) {
				System.out.println("Login was successful");
				int id=Query.getUserIdFromUsername(username);
				return new String[]{seeRole(id),Query.getName(id)};
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
			System.out.println("principal");
			return "principal";
		}
		else if(Query.isStudent(id)) {
			System.out.println("student");
			return "student";
		}
		else if(Query.isTeacher(id)) {
			System.out.println("teacher");
			return "teacher";
		}
		
		return "";
	}
	
}
