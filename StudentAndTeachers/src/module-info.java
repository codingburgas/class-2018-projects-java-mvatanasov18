module StudentAndTeachers {
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	
	opens main to javafx.graphics, javafx.fxml;
}
