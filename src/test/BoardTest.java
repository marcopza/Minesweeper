package test;

import junit.framework.TestCase;
import model.Board;
import model.Box;

public class BoardTest extends TestCase{

	private Board board;
	
	public void setUpScenario1() {
		
		board = new Board(1);
		
	}
	
	public void setUpScenario2() {
		
		board = new Board(2);
		
	}
	
	public void setUpScenario3() {
		
		board = new Board(3);
		
	}
	
	
	public void testProperBoardSize1() {
		
		setUpScenario1();
		assertEquals("Board built correctly", board.getColumns(), 8);
		
	}
	
	public void testCorrectBoardSize2() {
		
		setUpScenario2();
		assertEquals("Board built correctly", board.getColumns(), 16);
		
	}
	
	public void testCorrectBoardSize3() {
		
		setUpScenario3();
		assertEquals("Board built correctly", board.getColumns(), 30);
		
	}
	
	public void testNumberOfMines1() {
		
		setUpScenario1();
		assertEquals("The number of mines is correct", board.getNumberOfMines(), Board.MINES_BEGIN);
		
	}
	
	public void testNumberOfMines2() {
		
		setUpScenario2();
		assertEquals("The number of mines is correct", board.getNumberOfMines(), Board.MINES_INTER);
		
	}
	
	public void testNumberOfMInes3() {
		
		setUpScenario3();
		assertEquals("The number of mines is correct", board.getNumberOfMines(), Board.MINES_EXPER);
		
	}
	
	public void testCorrectNumberReturned1() {
		
		int numberOfMines = 0;
		Box box;
		Box[][] copyBoard;
		setUpScenario1();
		copyBoard = board.getBoard();
		box = copyBoard[2][2];
		if(copyBoard[1][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][3].getIsMine()) {
			numberOfMines++;
		}
		if(box.getIsMine()) {
			
			numberOfMines = -1;
			
		}
		assertEquals("The method works correctly", numberOfMines, board.chooseBox(2, 2));
	}
	
	
	public void testCorrectNumberReturned2() {
		
		int numberOfMines = 0;
		Box box;
		Box[][] copyBoard;
		setUpScenario2();
		copyBoard = board.getBoard();
		box = copyBoard[2][2];
		if(copyBoard[1][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][3].getIsMine()) {
			numberOfMines++;
		}
		if(box.getIsMine()) {
			
			numberOfMines = -1;
			
		}
		assertEquals("The method works correctly", numberOfMines, board.chooseBox(2, 2));
	}
	
	public void testCorrectNumberReturned3() {
		
		int numberOfMines = 0;
		Box box;
		Box[][] copyBoard;
		setUpScenario3();
		copyBoard = board.getBoard();
		box = copyBoard[2][2];
		if(copyBoard[1][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[1][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[2][3].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][2].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][1].getIsMine()) {
			numberOfMines++;
		}
		if(copyBoard[3][3].getIsMine()) {
			numberOfMines++;
		}
		if(box.getIsMine()) {
			
			numberOfMines = -1;
			
		}
		assertEquals("The method works correctly", numberOfMines, board.chooseBox(2, 2));
	}
}
