package model;

/**
*Fucntionality of the controller
*@author Marco Pérez and Julian Enciso
*@version 06.09.2018
*/

import exception.ExtraPressedButtonException;
import exception.RepeatedBoxException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Board;

public class Functionality {

	private Board gameBoard;
	private GridPane gamePane;
	private int won;
	
	
	/**
	 * Constructor method of the class. <br>
	 * <b>pre:</b> The GridPane should be initialized. <br>
	 * @param difficulty - difficulty of the game.
	 * @param gamePane - GridPane corresponding to the desired difficulty.
	 */
	public Functionality(int difficulty, GridPane gamePane) {
		gameBoard = new Board(difficulty);
		this.gamePane = gamePane;
		won =0;
	}
	
	/**
	 * Method which returns the amount of mines surrounding an specific box or if it is a mine. <br>
	 * @param event - action of clicking on a button. 
	 * @return number - returns the number of mines surrounding the box.
	 * @throws RepeatedBoxException
	 * @throws ExtraPressedButtonException
	 */
	public int buttonPressed(ActionEvent event) throws RepeatedBoxException, ExtraPressedButtonException{
		
		int result = 0;
		int i;
		int j;
    	Button btn = (Button) event.getSource();
    	if(checkIfWon()) {
			throw new ExtraPressedButtonException("The game has already ended");
		}
    	if(btn.getText().equals("")) {
	    	i = gamePane.getRowIndex(btn);
	    	j = gamePane.getColumnIndex(btn); 
	    	result = gameBoard.chooseBox(i-1, j-1);
	    	if(result > -1) {
	    		won++;
	    		btn.setText(Integer.toString(result));
	    		
	    	}
	    	else {
	    		btn.setText("*");
	    	}
			return result;
    	}
    	else {
    		throw new RepeatedBoxException("You're opening an open box");
    	}
    	
	}
	
	/**
	 * Method which uncovers the next closed box which isn't a 0 or a mine. <br>
	 * <b>pre:</b> The board has to be initialized. <br>
	 * <b>pre:</b> The GridPane must be initialized. <br>
	 * <b>post:</b> The text of the button is modified. <br>
	 */
	public void clueButtonPressed() {
		Button btn;
		for(Node node : gamePane.getChildren()) {
    		btn = (Button) node;
        	int i = gamePane.getRowIndex(btn);
        	int j = gamePane.getColumnIndex(btn);
        		if("".equals(btn.getText())) {
        			if(gameBoard.getColumns() == Board.BEGINNER) {
        				if(i > 8 || j > 8) {
        					break;
        				}
        				
        			}
        			else if(gameBoard.getColumns() == Board.INTERMEDIATE) {
        				if(i > 16 || j > 16) {
        					break;
        				}
        				
        			}
        			else {
        				if(i > 16 || j > 30) {
        					break;
        				}
        			}
            		if(gameBoard.chooseBox(i-1, j-1) > 0) {
            			btn.setText(Integer.toString(gameBoard.chooseBox(i-1, j-1)));
            			won++;
            			break;
            		}
        		}
    	}
	}
	
	/**
	*Method which modifies the text of all the buttons so the board is displayed. <br>
	*<b>pre:</b> The gamePane has to match the GridPane initialized.<br>
	*<b>pre:</b> The board has to be initialized. <br>
	*/
	public void solutionButtonPressed() {
		
		Button btn;
		int i;
		int j;
		for(Node node : gamePane.getChildren()) {
			btn = (Button) node;
			i = gamePane.getRowIndex(btn);
    		j = gamePane.getColumnIndex(btn);
    		if(gameBoard.getColumns() == Board.BEGINNER) {
    			if(i > 8 || j > 8) {
    				break;
    			}
    		}
    		else if(gameBoard.getColumns() == Board.INTERMEDIATE) {
    			if(i > 16 || j > 16) {
    				break;
    			}
    		}
    		if(gameBoard.getColumns() == Board.C_EXPERT) {
    			if(i > 16 || j > 30) {
    				break;
    			}
    		}
    		if(gameBoard.chooseBox(i-1, j-1) > -1) {
    			btn.setText(Integer.toString(gameBoard.chooseBox(i-1, j-1)));
    		}
    		else {
    			btn.setText("*");
    		}
		}
	}
	
	/**
	 * Method which opens the desired box, indicated by the indexes. <br>
	 * @param i - index which denotes the row of the desired box.
	 * @param j - index which denotes the column of the desired box.
	 * @return number - the number of mines surrounding the box or -1 if it is a mine.
	 * @throws RepeatedBoxException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int selectionByIndex(int i, int j) throws RepeatedBoxException, ArrayIndexOutOfBoundsException {
		
		if(gameBoard.getColumns() == Board.BEGINNER) {
			if(i > 8 || j > 8 || i < 1 || j < 1) {
				throw new ArrayIndexOutOfBoundsException("The selected position does not exist in the board.");
			}
			
		}
		else if(gameBoard.getColumns() == Board.INTERMEDIATE) {
			if(i > 16 || j > 16 || i < 1 || j < 1) {
				throw new ArrayIndexOutOfBoundsException("The selected position does not exist in the board.");
			}
			
		}
		else {
			if(i > 16 || j > 30 || i < 1 || j < 1) {
				throw new ArrayIndexOutOfBoundsException("The selected position does not exist in the board.");
			}
		}
		
		Button btn;
		Button comparison;
		int result = -3;
		for(Node node : gamePane.getChildren()) {
			comparison = (Button) node;
			if(gamePane.getRowIndex(comparison) == i && gamePane.getColumnIndex(comparison) == j) {
				btn = comparison;
				if(!btn.getText().equals("")) {
					
					throw new RepeatedBoxException("You've opened an open box");
					
				}
				if(gameBoard.chooseBox(i-1, j-1) > -1) {
					btn.setText(Integer.toString(gameBoard.chooseBox(i-1, j-1)));
					result = gameBoard.chooseBox(i-1, j-1);
					break;
				}
				else {
					btn.setText("*");
					result = gameBoard.chooseBox(i-1, j-1);
					break;
				}
			}
			
		}

		return result;
		
	}
	
	/**
	 * Method which allows the user to place an exclamation mark where he or she assumes is a mine. <br>
	 * <b>pre:</b> The board has to be initialized. <br>
	 * <b>pre:</b> The GridPane has to be initialized. <br>
	 * @param event - the click of the mouse.
	 */
	public void placeOrRemoveFlag(MouseEvent event) {
		Text t;
		t = new Text("!");
		t.setFill(Color.RED);
		Button btn = (Button) event.getSource();
		if(event.getButton().equals(MouseButton.SECONDARY)) {
			if(btn.getText().equals("")) {
				btn.setText(t.getText());
			}
			else if(btn.getText().equals(t.getText())) {
				btn.setText("");
			}
		}
		
	}
	
	/**
	 * Method which checks if the user has won the game or not. <br>
	 * <b>pre:</b> The board has to be initialized. <br>
	 * <b>pre:</b> The GridPane has to be initialized. <br>
	 * <b>pos:</b> Returns a boolean denotiing if the person has won or not. <br>
	 * @return boolean - boolean which denotes if the user has won or not. 
	 */
	public boolean checkIfWon() {
		if(gameBoard.getColumns() == Board.BEGINNER) {
			if(won == ((Board.BEGINNER * Board.BEGINNER) - Board.MINES_BEGIN)) {
				return true;
			}
		}
    	else if(gameBoard.getColumns() == Board.INTERMEDIATE) {
			if(won == ((Board.INTERMEDIATE * Board.INTERMEDIATE) - Board.MINES_INTER)) {
				return true;
			}
		}
    	else {
    		if(won == ((Board.INTERMEDIATE * Board.INTERMEDIATE) - Board.MINES_INTER)) {
    			return true;
    		}
    	}
		return false;
	}
	
	
}
