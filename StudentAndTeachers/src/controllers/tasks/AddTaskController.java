package controllers.tasks;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import javafx.scene.layout.HBox;
import models.AddTaskModel;
import models.Student;
import models.Task;


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
				currentStudent=listStudents.getSelectionModel().getSelectedItem();
				LocalDate chosenDate=dueDate.getValue();
				String date=chosenDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				System.out.println("date: "+date);
				System.out.println(currentStudent);
			}
		});
		
	}
	
	public void submit() {
		
		LocalDate chosenDate=dueDate.getValue();
		
		new AddTaskModel()
		.addTask(new Task(
				chosenDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				title.getText().toString(),
				description.getText().toString(),
				currentStudent
				));
		
		
	}
	
	
	
	
}
