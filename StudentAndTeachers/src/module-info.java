module StudentAndTeachers {
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.fxml;
	requires AnimateFX;
	
	opens main to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
}
