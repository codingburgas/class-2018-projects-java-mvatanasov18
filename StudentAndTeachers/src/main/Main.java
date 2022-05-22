package main;
	
import controllers.HomeController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.IndexView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			System.out.println("Start");
			
			IndexView mainWindow=new IndexView(primaryStage);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
