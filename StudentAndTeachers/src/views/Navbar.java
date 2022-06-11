package views;

import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class Navbar {

	public void addButton(String name, ToolBar navbar) {
		Button btn = new Button(name);

		btn.setOnAction(generateEventHandler(name));
		navbar.getItems().add(btn);
	}

	private EventHandler generateEventHandler(String name) {

		if (name.equalsIgnoreCase("home")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Home");
					new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		} else if (name.equalsIgnoreCase("register")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Register");
					new RegisterView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		} else if (name.equalsIgnoreCase("logout")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Logout");
					Session.isLoggedIn = false;
					Session.name = "";
					Session.role = "";
					new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		} else if (name.equalsIgnoreCase("Login")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("login");
					new LoginView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		}
		else if (name.equalsIgnoreCase("Add")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("add");
						new AddView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}else if (name.equalsIgnoreCase("Teams")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("teams");
						new TeamsView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}
			else if (name.equalsIgnoreCase("Calendar")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("calendar");
						new CalendarView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}
			else if (name.equalsIgnoreCase("View tasks")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("view tasks");
						new TasksView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}

		return null;
	}

	
}
