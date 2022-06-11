package views;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.AddController;
import controllers.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class AddView extends Navbar {

	private AddController ac;

	public AddView(Stage stage) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Add.fxml"));

			Parent root = loader.load();

			ac = loader.getController();

			Navbar n = new Navbar();
			ToolBar tb = ac.getNavbar();
			if (Session.getRole().equals("principal")) {

				n.addButton("Logout", tb);
				n.addButton("Teams", tb);
				n.addButton("View Tasks", tb);
				n.addButton("Calendar", tb);
			}
			stage.setTitle("Students and Teachers");

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
