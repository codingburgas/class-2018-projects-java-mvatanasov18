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
import javafx.stage.Stage;

public class IndexView {

	public IndexView(Stage stage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Index.fxml"));

			Parent root = loader.load();
			HomeController hc = loader.getController();
			stage.setTitle("Students and Teachers");
			try {
				if (Session.name != "") {
					System.out.println(Session.name);

					hc.setText(", "+ Session.name);
				}
			} catch (Exception e) {
				// System.out.println("user is null");
				e.printStackTrace();
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
