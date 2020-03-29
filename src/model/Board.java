package model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
*Board class of the model
*@author Marco Pérez and Julian Enciso
*@version 06.09.2018
*/

public class Board {
	
		public static final int BEGINNER = 8;
		public static final int INTERMEDIATE = 16;
		public static final int R_EXPERT = 16;
		public static final int C_EXPERT = 30;
		public static final int MINES_BEGIN = 10;
		public static final int MINES_INTER = 40;
		public static final int MINES_EXPER = 99;
		private Box board[][];
		private String mines[];

		/** 
		 * Constructor method of the class. <br>
		 * <b>pre: </b> The difficulty level has been chosen. <br>
		 * @param difficulty - Number that represents the difficulty level chosen by the user. difficulty != null.<br>
		 */
		public Board(int difficulty){
			
			createBoard(difficulty);
			
		}
		
	/**  
	 * This method creates the game board
	 * <b>pre: </b> The difficulty level has been chosen. <br>	
	 * @param difficulty - difficulty - Number that represents the difficulty level chosen by the user. difficulty != null.<br>
	 */
		
		public void createBoard(int difficulty){
			
			if(difficulty == 1){
				
				board = new Box[BEGINNER][BEGINNER];
				mines = new String[MINES_BEGIN];
				
			}
			else if(difficulty == 2){
				
				board = new Box[INTERMEDIATE][INTERMEDIATE];
				mines = new String[MINES_INTER];
				
			}
			else{
				
				board = new Box[R_EXPERT][C_EXPERT];
				mines = new String[MINES_EXPER];
			
			}
			String newMine = "";
			int m;
			int n;
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[0].length; j++){
					
					board[i][j] = new Box(false);
		
				}
			}
			
			for(int contador = 1; contador < mines.length; contador++){
				
				if(mines[0] == null){
				m = ThreadLocalRandom.current().nextInt(0, board.length);
				n = ThreadLocalRandom.current().nextInt(0, board[0].length);
				newMine += m+" "+n;
				mines[0] = newMine;
				newMine = "";
				board[m][n].setIsMine(true);
				}
				do{
				m = ThreadLocalRandom.current().nextInt(0, board.length);
				n = ThreadLocalRandom.current().nextInt(0, board[0].length);
				newMine += m+" "+n;
				}while(Arrays.asList(mines).contains(newMine));
				mines[contador] = newMine;
				newMine = "";
				board[m][n].setIsMine(true);
			}
			
		}
		
		
		/**  
		 * Method that receives two numbers and verifies in which box the user is located, and returns the number of mines on the board <br> 
		 * <b>pre: </b> The box has been chosen. <br>	
		 * @param i,j. numbers that represents the position of the box that the user wants to open. i != null, j != null. <br>
		 * @return numMinas - number of mines that the box has around.
		 */

		public int chooseBox(int i, int j){
			
			int numMinas = 0;
			if(board[i][j].getIsMine()){
	
				return -1;
				
			}
			//fin if
			else{
				if((i-1) >= 0){
					
					if(board[i-1][j].getIsMine()){
						
						numMinas++;
						
					}
					//fin if
					if((j-1) >= 0){
						
						if(board[i-1][j-1].getIsMine()){
						
							numMinas++;
						
						}
					}
					//fin if
					if((j+1) < board[0].length){
						
						if(board[i-1][j+1].getIsMine()){
						
							numMinas++;
						
						}
					}
					//fin if
				}
				//fin if
				if((j+1) < board[0].length){
						
					if(board[i][j+1].getIsMine()){
						
						numMinas++;
						
					}
					//fin if
				}
				//fin if
				if((j-1) >= 0){
						
					if(board[i][j-1].getIsMine()){
						
						numMinas++;
						
					}
					//fin if
				}
				//fin if
				if((i+1) < board.length){
					
					if(board[i+1][j].getIsMine()){
						
						numMinas++;
						
					}
					//fin if
					if((j-1) >= 0){
						
						if(board[i+1][j-1].getIsMine()){
						
							numMinas++;
						
						}
						//fin if
					}
					//fin if
					if((j+1) < board[0].length){
						
						if(board[i+1][j+1].getIsMine()){
						
						numMinas++;
						
						}
					}
					//fin if
				}
				//fin if
			}
			return numMinas;
		}
		
		
		/**
		 * Method which returns the number of columns in the created board. <br>
		 * <b>pre:</b> The board should has to be initialized. <br>
		 * <b>pos:</b> Returns the number of columns. <br>
		 * @return columns - number of columns related to the size of the board.
		 */
		public int getColumns(){
			return board[0].length;
		}
		
		/**
		 * Method which returns the game board.<br>
		 * <b>pre:</b> The board must be initialized.<br>
		 * @return board - the board of Boxes.
		 */
		public Box[][] getBoard(){
			
			return board;
			
		}
		
		/**
		 * Method which returns the number of mines in the generated board. <br>
		 * <b>pre:</b> The matrix Board has to be initialized. <br>
		 * <b>pre:</b> The array mines has to be initialized. <br>
		 * @return mines - number of mines in the whole Board. 
		 */
		public int getNumberOfMines() {
			
			boolean notNull = false;
			
			for(int i = 0; i < mines.length; i++) {
				
				if(mines[i] != null) {
					
					notNull = true;
					
				}
				else {
					
					notNull = false;
					
				}
				
			}
			if(notNull) {
				return mines.length;
			}
			else {
				return 0;
			}
			
		}
}