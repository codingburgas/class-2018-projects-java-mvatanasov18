package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.HomeController;
import controllers.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class IndexView extends Navbar {
	private HomeController hc;

	public IndexView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Index.fxml"));

			Parent root = loader.load();
			hc = loader.getController();
			stage.setTitle("Students and Teachers");
			Navbar n=new Navbar();
			ToolBar tb=hc.getNavbar();
			
			System.out.println("role: "+Session.role);
			
			if (Session.name.equals("")) {
				
				
				
				
				n.addButton("Login", tb);
				n.addButton("Register", tb);
				
			}else if( Session.role.equals("principal")) {
				hc.setText(", " + Session.name);
				n.addButton("Logout", tb);
				n.addButton("Add", tb);
				n.addButton("Teams", tb);
				n.addButton("View Tasks", tb);
				n.addButton("Calendar", tb);
			}else if( Session.role.equals("student") || Session.role.equals("teacher")) {
				hc.setText(", " + Session.name);
				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("View Tasks", tb);
				n.addButton("Calendar", tb);
			}

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/main/application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();

			new FadeIn(root).play();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
