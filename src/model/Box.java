package model;

/**
*Box class of the model
*@author Marco Pérez and Julian Enciso
*@version 29.04.2018
*/

public class Box {

	
	//Atributos
	private boolean isMine;
	
	//Métodos
	/**
	*Constructor method of the class. <br>
	*<b>pre: </b> the box couldn´t be a mineif the maximun number of mines per difficulty has been reached. <br>
	*<b>pre: </b> tha corresponding matrix to the board must be inicialized (board != null). <br>
	*<b>post: </b> A new box is created, it is stored on the matrixz. <br>
	*@param isMine - condition that will determinate if a box is or is not a mine. isMine != null. <br>
	*/
	public Box(boolean isMine){
		
		this.isMine = isMine;
		
	}
	
	/**
	*Method that returns the value of the variable isMine. <br>
	*<b>pre: </b> the corresponding Box object must be inicialized. box != null <br>
	*<b>pre: </b> The value of isMine must be boolean and be inicialized. inMine != null <br>
	*<b>post: </b> is returned the boolean value to the corresponding variable isMine <br>
	*@return isMine - Boolean value that determinates if the box choosed by the user is or in not a Mine. <br>
	*/
	public boolean getIsMine(){
		
		return isMine;
		
	}
		
	/**
	*Method that modifies the value of the variable isMine. <br>
	*<b>pre: </b> the corresponding Box object must be inicialized. box != null. <br>
	*<b>pre: </b> the text value must be a text String and be inicialized. text != null. <br>
	*<b>post: </b> The stored value is modified in the variable isMine. <br>
	*@param isMine - Boolean value that will determinates if the box choosed by the user is or in not a Mine <br>
	*/
	public void setIsMine(boolean isMine){
		
		this.isMine = isMine;
		
	}
	
}