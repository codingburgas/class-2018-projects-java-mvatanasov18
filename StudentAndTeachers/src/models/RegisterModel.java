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

		if (areBlank()) {
			return "Please enter data";
		}
		if (!isPasswordOk()) {
			return "Password is too small/not equal to confirm password";
		}
		if (!validateNumber(phone)) {
			return "Phone number is wrong\nAcceptable pattern:0XXXXXXXXX";
		}

		if (isUsernameUnique()) {
			int id = Query.insertUser(username, password, firstName, lastName, address);

			Query.insertPrincipal(id, schoolName);
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

		String rs = Query.findDuplicateUsername(username);

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
		if (phone.isBlank()) {
			return true;
		}
		if (schoolName.isBlank()) {
			return true;
		}

		return false;
	}

	private void moveUserToPrincipal() {

	}

	// function validates mobile numbers
	private  boolean validateNumber(String mobNumber) {
		// validates phone numbers having 10 digits (9998887776)
		if (mobNumber.matches("\\d{10}"))
			return true;
		// validates phone numbers having digits, -, . or spaces
		else if (mobNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		else if (mobNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
			return true;
		// validates phone numbers having digits and extension (length 3 to 5)
		else if (mobNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validates phone numbers having digits and area code in braces
		else if (mobNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		else if (mobNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
			return true;
		else if (mobNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
			return true;
		// return false if any of the input matches is not found
		else
			return false;
	}
}
