package models.Add;

import models.Session;
import models.Validator;
import models.db.Query;

public class CreateStudentModel {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String confirmPassword;
	private String phone;
	private String parentEmail;
	private String parentPhone;
	private String parentAddress;
	

	
	public CreateStudentModel(String username, String password, String firstName, String lastName, String address,
			String confirmPassword, String phone, String parentEmail, String parentPhone, String parentAddress) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
		this.parentEmail = parentEmail;
		this.parentPhone = parentPhone;
		this.parentAddress = parentAddress;
	}


	public String checkStudentRegister() {
		
		System.out.println("	begin check");
		Validator v=new Validator();
		if (v.areBlank( new String[] {username,password,firstName,lastName,
				address, confirmPassword,phone,parentEmail,parentPhone,parentAddress} )) {
			return "Please enter data";
		}
		if (!v.isPasswordOk(password,confirmPassword)) {
			return "Password is too small/not equal to confirm password";
		}
		if (!v.validateNumber(phone)) {
			return "Phone number is wrong\nAcceptable pattern:0XXXXXXXXX";
		}

		if (v.isUsernameUnique(username)) {
			System.out.println("School name: "+Session.getSchoolName());
			int id = Query.insertUser(username, password, firstName, lastName, address,phone,Session.getSchoolName());

			Query.insertStudent(id, parentPhone, parentEmail, parentAddress);
			Session.setUserName(firstName);
			return "Successfully added a student with name: "+firstName;
		}

		
		return "username is taken";
	}

	
}
