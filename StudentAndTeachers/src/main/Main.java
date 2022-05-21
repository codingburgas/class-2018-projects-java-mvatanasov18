package main;
	
import controllers.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.Index;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			System.out.println("Start");
			
			Index mainWindow=new Index(primaryStage);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
