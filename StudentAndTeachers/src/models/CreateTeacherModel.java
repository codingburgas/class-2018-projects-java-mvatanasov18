package models;

import controllers.Session;

public class CreateTeacherModel {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String confirmPassword;
	private String phone;
	private String subjectName;
	

	
	public CreateTeacherModel(String username, String password, String firstName, String lastName, String address,
			String confirmPassword, String phone, String subjectName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
		this.subjectName = subjectName;
	}


	public String checkTeacherRegister() {
		
		System.out.println("	begin check");
		Validator v=new Validator();
		if (v.areBlank( new String[] {username,password,firstName,lastName,
				address, confirmPassword,phone,subjectName} )) {
			return "Please enter data";
		}
		if (!v.isPasswordOk(password,confirmPassword)) {
			return "Password is too small/not equal to confirm password";
		}
		if (!v.validateNumber(phone)) {
			return "Phone number is wrong\nAcceptable pattern:0XXXXXXXXX";
		}

		if (v.isUsernameUnique(username)) {
			int id = Query.insertUser(username, password, firstName, lastName, address,phone,Session.getSchoolName());
			Session.setUserName(firstName);
			Query.insertTeacher(id,subjectName);
			return "Successfully added a user with name: "+firstName;
		}

		
		return "username is taken";
	}

	
}
