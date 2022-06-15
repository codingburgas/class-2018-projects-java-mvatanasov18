package views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import models.Session;
import views.Add.AddView;
import views.tasks.TasksView;

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
					Session.setLoggedIn(false);
					Session.setName("");
					Session.setRole("");
					Session.setSchoolName("");
					Session.setUserName("");
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
			else if (name.equalsIgnoreCase("Tasks")) {
				return new EventHandler() {

					@Override
					public void handle(Event event) {
						System.out.println("tasks");
						new TasksView((Stage) ((Node) event.getSource()).getScene().getWindow());
					}

				};
			}

		return null;
	}

	
}
