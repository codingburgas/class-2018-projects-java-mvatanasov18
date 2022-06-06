package views;

import controllers.Session;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class Navbar {

	
	public void addButton(String name,ToolBar navbar) {
		Button btn=new Button(name);
		btn.setOnAction(new EventHandler() {


			@Override
			public void handle(Event event) {
				System.out.println(name);
				CalendarView calendar=new CalendarView((Stage) ((Node) event.getSource()).getScene().getWindow());
			}
		});
		navbar.getItems().add(btn);
	}
	
	
	
	public void setNavbarOptionsBySessionRole(ToolBar navbar) {
		
		if(Session.role.equals("principal")) {
			addButton("Calendar",navbar);
			addButton("Add",navbar);
			addButton("View tasks",navbar);
			addButton("Teams",navbar);
			return;
		}
		if (Session.role.equals("teacher")) {
			addButton("Calendar",navbar);
			addButton("View tasks",navbar);
			addButton("Teams",navbar);
			return;
		}
		
		if (Session.role.equals("student")) {
			addButton("Calendar",navbar);
			addButton("View tasks",navbar);
		}
		
	}
}
