package controllers.tasks;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Student;
import models.tasks.AddTaskModel;
import models.tasks.Task;
import models.tasks.UpdateTaskModel;
import views.tasks.AddTaskView;
import views.tasks.UpdateTaskView;


public class UpdateTaskController implements Initializable {

	
	@FXML
	private ToolBar navbar;
	@FXML
	private DatePicker dueDate;
	@FXML
	private TextField title;
	@FXML
	private TextField taskId;
	@FXML
	private ListView<Student> listStudents;
	@FXML
	private TextArea description;
	@FXML
	private Label errorMessage;
	private List<Student> students;
	private Student currentStudent;
	
	public UpdateTaskController() {
		students=new AddTaskModel().getStudents();
	}
	
	//GETTERS
	public ToolBar getNavbar() {
		return navbar;
	}
	public List<Student> getStudents(){
		return students;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listStudents.getItems().addAll(students);
		
		listStudents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {

			@Override
			public void changed(ObservableValue<? extends Student> arg0, Student arg1, Student arg2) {
				try {
				currentStudent=listStudents.getSelectionModel().getSelectedItem();
				LocalDate chosenDate=dueDate.getValue();
				String date=chosenDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				System.out.println("date: "+date);
				System.out.println(currentStudent);
				}
				catch(Exception e){
					errorMessage.setText("Invalid date format. Please click the calendar icon");
				}
			}
		});
		
	}
	
	public void submit(ActionEvent event)  {
		try {
		LocalDate chosenDate=dueDate.getValue();
Task t=new Task(
		java.sql.Date.valueOf(chosenDate),
		title.getText().toString(),
		description.getText().toString(),
		currentStudent
		);
	t.setTaskId(Integer.parseInt( taskId.getText().toString()));
		String message=new UpdateTaskModel().updateTask(t);
		if(message.equals("Error")) {
			errorMessage.setText("Invadid data");
		}else {
			new UpdateTaskView((Stage) ((Node) event.getSource()).getScene().getWindow());
		}
		
		}catch(DateTimeParseException dtpe) {
			errorMessage.setText("Invalid date format. Please click the calendar icon");
		}
		catch(Exception e ) {
			errorMessage.setText("Enter data");
		}
		
	}
	
	
	
	
}
