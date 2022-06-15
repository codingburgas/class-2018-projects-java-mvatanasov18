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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import models.Student;
import models.tasks.AddTaskModel;
import models.tasks.Task;


public class AddTaskController implements Initializable {

	
	@FXML
	private ToolBar navbar;
	@FXML
	private DatePicker dueDate;
	@FXML
	private TextField title;
	@FXML
	private ListView<Student> listStudents;
	@FXML
	private TextArea description;
	@FXML
	private Label errorMessage;
	private List<Student> students;
	private Student currentStudent;
	
	public AddTaskController() {
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
	
	public void submit()  {
		try {
		LocalDate chosenDate=dueDate.getValue();

		new AddTaskModel()
		.addTask(new Task(
				java.sql.Date.valueOf(chosenDate),
				title.getText().toString(),
				description.getText().toString(),
				currentStudent
				));
		}catch(DateTimeParseException dtpe) {
			errorMessage.setText("Invalid date format. Please click the calendar icon");
		}
		catch(Exception e ) {
			errorMessage.setText("Enter data");
		}
		
	}
	
	
	
	
}
