package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
*Main class of the view
*@author Marco Pérez and Julian Enciso
*@version 10.08.2018
*/

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Start.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle(null);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
