package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.db.Query;

public class Validator {
	public boolean isUsernameUnique(String username) {

		String rs = Query.findDuplicateUsername(username);

		if (rs == "") {
			System.out.println("	true");
			return true;
		}
		System.out.println("	false");
		return false;
	}

	public boolean areBlank(String fields[]) {
		for (String field : fields) {
			if (field.isBlank()) {
				return true;
			}
		}

		return false;
	}
	
	
	
	// true- password's length is at least 8 chars and equals confirmPassword
	// false password's length smaller than 8 chars or not equals confirmPassword
	public boolean isPasswordOk(String password,String confirmPassword) {

		if (password.length() >= 8) {
			if (password.equals(confirmPassword)) {
				return true;
			}
		}

		return false;
	}

	
	// function validates mobile numbers
	public  boolean validateNumber(String phone) {
	    String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	    Pattern pattern = Pattern.compile(patterns);
	    Matcher matcher = pattern.matcher(phone);
	    
	    return matcher.matches();
	    
	}
}
