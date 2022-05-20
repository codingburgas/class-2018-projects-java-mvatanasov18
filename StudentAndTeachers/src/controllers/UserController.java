package controllers;

import javafx.event.ActionEvent;
import models.Query;

public class UserController {
	public void checkConnection() {
		new Query().testQuery();
	}
	
	public void home(ActionEvent e) {
		System.out.println("Home");
	}
	public void logIn(ActionEvent e) {
		System.out.println("logIn");
	}
	public void register(ActionEvent e) {
		System.out.println("register");
	}
}
