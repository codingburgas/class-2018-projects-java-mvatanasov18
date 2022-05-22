package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String confirmPassword;

	public RegisterModel(String username, String password, String firstName, String lastName, String address,
			String confirmPassword) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.confirmPassword = confirmPassword;
	}

	public String checkRegister() {
		System.out.println("	begin check");
		
		if(areBlank()) {
			return "Please enter data";
		}
		if(!isPasswordOk()) {
			return "Password is too small/not equal to confirm password";
		}
		
		if(isUsernameUnique()) {
			int rows =Query.insertUser(username, password, firstName, lastName, address);
			
			System.out.println("Affected rows: "+rows);
			return "all Ok";
		}
		

		return "username is taken";
	}

	// true- password's length is at least 8 chars and equals confirmPassword
	// false password's length smaller than 8 chars or not equals confirmPassword
	private boolean isPasswordOk() {

		if (password.length() >= 8) {
			if (password.equals(confirmPassword)) {
				return true;
			}
		}

		return false;
	}

	private boolean isUsernameUnique() {

		String rs = Query.findUserByUsername(username);
		
		if (rs == "") {
			System.out.println("	true");
			return true;
		}
		System.out.println("	false");
		return false;
	}

	private boolean areBlank() {
		if (username.isBlank()) {
			return true;
		}
		if (password.isBlank()) {
			return true;
		}
		if (firstName.isBlank()) {
			return true;
		}
		if (lastName.isBlank()) {
			return true;
		}
		if (address.isBlank()) {
			return true;
		}

		return false;
	}

}
