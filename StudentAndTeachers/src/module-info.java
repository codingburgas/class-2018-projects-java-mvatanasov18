module StudentAndTeachers {
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.fxml;
	requires AnimateFX;
	
	opens main to javafx.graphics, javafx.fxml,javafx.base;
	opens controllers to javafx.graphics, javafx.fxml,javafx.base;
	opens controllers.tasks to javafx.graphics, javafx.fxml,javafx.base;
	opens controllers.teams to javafx.graphics, javafx.fxml,javafx.base;
	opens controllers.Add to javafx.graphics, javafx.fxml,javafx.base;
	opens models.tasks to javafx.graphics, javafx.fxml,javafx.base;
}
