package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Main;
import controller.BoardController;;

/**
*MenuController class of the controller
*@author Marco Pérez and Julian Enciso
*@version 10.08.2018
*/

public class MenuController implements Initializable {
	
    @FXML
    /**
   	*Method that recognize the action of press a button on the interface. <br>
   	*@param event - is the action that will be recognized. <br>
   	*/
    private void beginnerButtonPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Beginner.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Beginner");
			window.show();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
    }

    @FXML
    /**
   	*Method that recognize the action of press a button on the interface. <br>
   	*@param event - is the action that will be recognized. <br>
   	*/
    private void expertButtonPressed(ActionEvent event) {	
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("/view/Expert.fxml"));
				Parent root = (Parent) loader.load();
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.setTitle("Expert");
				window.show();
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
    }

    @FXML
    /**
   	*Method that recognize the action of press a button on the interface. <br>
   	*@param event - is the action that will be recognized. <br>
   	*/
    private void intermediateButtonPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Intermediate.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Intermediate");
			window.show();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
