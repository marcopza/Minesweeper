package controller;

/**
*BeginnerController class of the controller
*@author Marco Pérez and Julian Enciso
*@version 06.09.2018
*/

import java.net.URL;
import java.util.ResourceBundle;

import exception.ExtraPressedButtonException;
import exception.RepeatedBoxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Board;
import model.Functionality;
import view.Main;

public class BoardController implements Initializable{

    @FXML
    private GridPane expertGridPane;
    
    @FXML
    private GridPane beginnerGridPane;
    
    @FXML
    private GridPane intermediateGridPane;
    
    @FXML
    private TextField beginnerRowTextField;

    @FXML
    private TextField beginnerColumnTextField;

    @FXML
    private TextField intermediateRowTextField;

    @FXML
    private TextField intermediateColumnTextField;
    
    @FXML
    private TextField expertRowTextField;

    @FXML
    private TextField expertColumnTextField;
    
    private Functionality functions;
	
    @FXML
    /**
	*Method that recognize the action of press a button on the interface. <br>
	*This method functions for buttons in the beginner board. <br>
	*@param event - is the action that will be recognized. <br>
	*/
    private void boxSelected(ActionEvent event) {
    	int result;
    	try {
    		result = functions.buttonPressed(event);
	    	if(result > -1) {
            	if(functions.checkIfWon()) {
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.setTitle("YOU WON!");
        			alert.setHeaderText(null);
        			alert.setContentText("Congratulations!");
        			alert.showAndWait();
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

	    	else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Boom!");
				alert.setHeaderText(null);
				alert.setContentText("You've lost :c");
				alert.showAndWait();
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
    	catch(RepeatedBoxException repeat) {
    		System.out.println(repeat.getMessage());
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(null);
    		alert.setHeaderText(null);
    		alert.setContentText("You've selected an open box");
    		alert.showAndWait();
    	}
    	catch(ExtraPressedButtonException extra) {
    		System.out.println(extra.getMessage());
    	}
    }

        
    @FXML
    /**
	*Method that recognize the action of press a button on the interface, in this case, when the clue button is pressed.
	*Also, it will also give clues to help the user solve the game. <br>
	*This method is applicable for all clue buttons. <br>
	*@param event - is the action that will be recognized. <br>
	*/
    private void clueButtonPressed(ActionEvent event) {
    	if(functions.checkIfWon()) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("YOU WON!");
    		alert.setHeaderText(null);
    		alert.setContentText("Congratulations!");
    		alert.showAndWait();
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
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	functions.clueButtonPressed();
    }

    @FXML
    /**
	*Method which modifies the text of all the buttons so the board is displayed. <br>
	*<b>pre:</b> The gamePane has to match the GridPane initialized.<br>
	*<b>pre:</b> The board has to be initialized. <br>
	*@param event - the action of clicking on the button. 
	*/
    private void solutionButtonPressed(ActionEvent event) {
    	functions.solutionButtonPressed();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Solution");
		alert.setHeaderText(null);
		alert.setContentText("Next time with no help!");
		alert.showAndWait();
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
		catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    /**
	 * Method which opens the desired box, indicated by the indexes. <br>
	 * @param event - button press on the select button. 
	 */
    private void indexSelection(ActionEvent event) {
    	int result;
    	try {
    		if(beginnerGridPane != null) {
    			
    			result = functions.selectionByIndex(Integer.parseInt(beginnerRowTextField.getText()), Integer.parseInt(beginnerColumnTextField.getText()));
    			
    		}
    		else if(intermediateGridPane != null) {
    			
    			result = functions.selectionByIndex(Integer.parseInt(intermediateRowTextField.getText()), Integer.parseInt(intermediateColumnTextField.getText()));
    			
    		}
    		else{
    			
    			result = functions.selectionByIndex(Integer.parseInt(expertRowTextField.getText()), Integer.parseInt(expertColumnTextField.getText()));
    			
    		}
    		if(result > -1) {
            	if(functions.checkIfWon()) {
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.setTitle("YOU WON!");
        			alert.setHeaderText(null);
        			alert.setContentText("Congratulations!");
        			alert.showAndWait();
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
	    	else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Boom!");
				alert.setHeaderText(null);
				alert.setContentText("You've lost :c");
				alert.showAndWait();
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
    	catch(RepeatedBoxException repeat) {
    		System.out.println(repeat.getMessage());
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(null);
    		alert.setHeaderText(null);
    		alert.setContentText("You've selected an open box");
    		alert.showAndWait();
    	}
    	catch(ArrayIndexOutOfBoundsException out) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(null);
    		alert.setHeaderText(null);
    		alert.setContentText(out.getMessage());
    		alert.showAndWait();
    	}
    	catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(null);
    		alert.setHeaderText(null);
    		alert.setContentText("You've tried introducing a letter instead of a number.");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    /**
     * Method that receives a mouse click as action.<br>
     * Said action only applies to buttons on the board, not other children of the GridPane.
     * <b>post:</b> The 
     * @param event - the action related to the mouse event.
     */
    private void mousePressed(MouseEvent event) {
    	functions.placeOrRemoveFlag(event);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		if(beginnerGridPane != null) {
			
			functions = new Functionality(1, beginnerGridPane);
			
		}
		else if(intermediateGridPane != null) {
			
			functions = new Functionality(2, intermediateGridPane);
			
		}
		else{
			
			functions = new Functionality(3, expertGridPane);
			
		}
	
	}
}
