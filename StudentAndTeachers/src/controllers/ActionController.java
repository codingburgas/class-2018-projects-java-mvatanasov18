package controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import views.IndexView;
import views.LoginView;

public interface ActionController {
	public void home(ActionEvent event) ;
	public void logIn(ActionEvent event);
	public void register(ActionEvent event);
}
