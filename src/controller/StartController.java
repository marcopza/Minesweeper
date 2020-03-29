package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Main;

/**
*StartController class of the controller
*@author Marco Pérez and Julian Enciso
*@version 10.08.2018
*/


public class StartController {

    @FXML
    private void buttonPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Menu.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Menu");
			window.show();
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
    }

}
