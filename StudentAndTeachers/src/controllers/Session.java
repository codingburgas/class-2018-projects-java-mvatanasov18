package controllers;

public class Session {
private static boolean loggedIn=false;
private static String name="";
private static String role="";
private static String schoolName="";
private static String userName="";
private static int id=0;

public static boolean isLoggedIn() {
	return loggedIn;
}
public static void setLoggedIn(boolean loggedIn) {
	Session.loggedIn = loggedIn;
}
public static String getName() {
	return name;
}
public static void setName(String name) {
	Session.name = name;
}
public static String getRole() {
	return role;
}
public static void setRole(String role) {
	Session.role = role;
}
public static String getSchoolName() {
	return schoolName;
}
public static void setSchoolName(String schoolName) {
	Session.schoolName = schoolName;
}


public static String getUserName() {
	return userName;
}
public static void setUserName(String userName) {
	Session.userName= userName;
}
public static int getId() {
	return id;
}
public static void setId(int id) {
	Session.id = id;
}


}
