package views.Add;

import java.io.IOException;

import animatefx.animation.FadeIn;
import controllers.Add.CreateStudentController;
import controllers.Add.CreateTeacherController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.Session;
import views.Navbar;

public class CreateTeacherView extends Navbar {

	private CreateTeacherController ctc;

	public CreateTeacherView(Stage stage) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/create/CreateTeacher.fxml"));

			Parent root = loader.load();

			ctc = loader.getController();

			Navbar n = new Navbar();
			ToolBar tb = ctc.getNavbar();

			n.addButton("Logout", tb);
			n.addButton("Add", tb);
			n.addButton("Teams", tb);
			n.addButton("View Tasks", tb);
			n.addButton("Calendar", tb);

			if (!Session.getUserName().equals("")) {
				ctc.getBlock().setText("Added a user with name: " + Session.getUserName());
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
