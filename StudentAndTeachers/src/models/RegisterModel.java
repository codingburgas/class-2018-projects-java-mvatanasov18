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
	private String phone;
	private String schoolName;

	public RegisterModel(String username, String password, String firstName, String lastName, String address,
			String confirmPassword, String phone, String schoolName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
		this.schoolName = schoolName;
	}

	public String checkRegister() {
		System.out.println("	begin check");
		Validator v = new Validator();
		if (v.areBlank(new String[] { username, password, firstName, lastName,
				address, confirmPassword, phone,schoolName })) {
			return "Please enter data";
		}
		if (!v.isPasswordOk(password, confirmPassword)) {
			return "Password is too small/not equal to confirm password";
		}
		if (!v.validateNumber(phone)) {
			return "Phone number is wrong\nAcceptable pattern:0XXXXXXXXX";
		}

		if (v.isUsernameUnique(username)) {
			int id = Query.insertUser(username, password, firstName, lastName, address, phone);

			Query.insertPrincipal(id, schoolName);
			return "all Ok";
		}

		return "username is taken";
	}

}
