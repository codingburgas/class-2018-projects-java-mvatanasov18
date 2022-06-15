package controllers.tasks;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import models.Student;
import models.tasks.AddTaskModel;
import models.tasks.Task;
import models.tasks.ViewTasksModel;


public class DeleteTasksController  {

	
	@FXML
	private ToolBar navbar;
	@FXML
	private BorderPane pane;
	//GETTERS
	public ToolBar getNavbar() {
		return navbar;
	}
	public BorderPane getPane() {
		return pane;
	}
	
	public Map<Integer,Task> getTasks(){
		return new ViewTasksModel().getTasks();
	}

	public int deleteTask(int taskId) {
		return new ViewTasksModel().deleteTaskById(taskId);
	}
}
