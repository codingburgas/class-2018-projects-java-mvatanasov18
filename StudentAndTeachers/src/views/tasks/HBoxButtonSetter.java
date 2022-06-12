package views.tasks;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxButtonSetter {

	public void addButtonToHBox(String name,HBox box) {
		Button btn=new Button(name);
		
		btn.setOnAction(getEvent(name));
		btn.setStyle("-fx-font-size:19");
		btn.setMinSize(170, 70);
		box.getChildren().add(btn);
	}
	
	
	private EventHandler getEvent(String name) {
		if(name.equalsIgnoreCase("Add task")) {
			
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("add task");
					new AddTaskView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		}else if(name.equalsIgnoreCase("Delete task")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Delete task");
					//new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		}else if(name.equalsIgnoreCase("Update task")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("Update task");
					//new IndexView((Stage) ((Node) event.getSource()).getScene().getWindow());
				}

			};
		}
		else if(name.equalsIgnoreCase("View tasks")) {
			return new EventHandler() {

				@Override
				public void handle(Event event) {
					System.out.println("view tasks");
					new ViewTasksView((Stage) ((Node) event.getSource()).getScene().getWindow());
					
				}

			};
		}
		
		return null;
	}
	
}
