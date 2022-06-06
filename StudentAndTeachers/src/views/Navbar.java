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

						CalendarView calendar = new CalendarView(
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

						AddView add = new AddView((Stage) ((Node) event.getSource()).getScene().getWindow());

					}
				});
			}
		}
		if (name.equalsIgnoreCase("viewTasks")) {
			if (!child.equalsIgnoreCase(name)) {
			
			}
		}
		if (name.equalsIgnoreCase("teams")) {
			if (!child.equalsIgnoreCase(name)) {
				
			}
			
		}

		navbar.getItems().add(btn);
	}

	public void setNavbarOptionsBySessionRole(ToolBar navbar, String child) {
		System.out.println("na maika ti putkata");
		if (Session.role.equals("principal")) {
			this.child = child;

			addButton("Calendar", navbar);
			addButton("Add", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

			return;
		}
		if (Session.role.equals("teacher")) {

			addButton("Calendar", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

			return;
		}

		if (Session.role.equals("student")) {

			addButton("Calendar", navbar);
			addButton("View tasks", navbar);
			addButton("Teams", navbar);

		}

	}
}
