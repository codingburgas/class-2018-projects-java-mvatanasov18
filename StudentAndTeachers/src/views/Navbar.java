package views;

import java.util.ArrayList;
import java.util.List;

import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class Navbar {
	private String child;

	private void addButton(String name, ToolBar navbar) {
		Button btn = new Button(name);

		System.out.println(name);
		if (name.equalsIgnoreCase("calendar")) {
			if (!child.equalsIgnoreCase(name)) {
				btn.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {

						 new CalendarView(
								(Stage) ((Node) event.getSource()).getScene().getWindow());

					}
				});
			}
		}

		if (name.equalsIgnoreCase("add")) {
			if (!child.equalsIgnoreCase(name)) {
				btn.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {

						new AddView((Stage) ((Node) event.getSource()).getScene().getWindow());

					}
				});
			}
		}
		if (name.equalsIgnoreCase("View tasks")) {
			if (!child.equalsIgnoreCase(name)) {
				btn.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {

						 new TasksView((Stage) ((Node) event.getSource()).getScene().getWindow());

					}
				});
			}
		}
		if (name.equalsIgnoreCase("teams")) {
			if (!child.equalsIgnoreCase(name)) {
				btn.setOnAction(new EventHandler() {

					@Override
					public void handle(Event event) {

						 new TeamsView((Stage) ((Node) event.getSource()).getScene().getWindow());

					}
				});
			}
			
		}

		navbar.getItems().add(btn);
	}

	public void setNavbarOptionsBySessionRole(ToolBar navbar, String child) {
		if (Session.role.equals("principal")) {
			this.child = child;

			addButton("Calendar", navbar);
			addButton("Add", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

			return;
		}
		if (Session.role.equals("teacher")) {
			this.child = child;
			addButton("Calendar", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

			return;
		}

		if (Session.role.equals("student")) {
			this.child = child;
			addButton("Calendar", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

		}

	}
}
