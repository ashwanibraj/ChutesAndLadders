package com.ashwani.chutesLadders;

import java.util.Random;

public class Player{
	private String name;
	private int currentPlaceOnBoard = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return a random number between 1 and 6.
	 */
	public int spinTheSpinner() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}
	
	/**
	 * 
	 * @param spinnerResult
	 * @return moveComment for current move
	 */
	public String makeNextMove(int spinnerResult) {	
		int newPosition = this.getCurrentPlaceOnBoard() + spinnerResult;
		
		return this.checkAndUpdateCurrentPlaceOnBoard(newPosition);
	}
	
	/**
	 * Description 	- 	Validate new position. 
	 * 					Apply chute or ladder if applicable. 
	 * 					Generate comment.
	 * @param newPositionOnBoard
	 * @return moveComment
	 */
	private String checkAndUpdateCurrentPlaceOnBoard(int newPositionOnBoard) {
		StringBuffer moveComments = new StringBuffer();
		moveComments.append(this.getName() +": " + this.getCurrentPlaceOnBoard() + " --> ");
		
		if(newPositionOnBoard > GameBoard.WINNING_SQUARE) {
			moveComments.append(newPositionOnBoard + " -- Spin takes past " + GameBoard.WINNING_SQUARE + ". Don't move. --> " + this.getCurrentPlaceOnBoard());
		} else {
		
			moveComments.append(newPositionOnBoard);
			if(GameBoard.CHUTES.get(newPositionOnBoard) != null) {
				newPositionOnBoard = GameBoard.CHUTES.get(newPositionOnBoard);
				moveComments.append(" -- CHUTE -->");
				moveComments.append(newPositionOnBoard);
			} else if(GameBoard.LADDERS.get(newPositionOnBoard) != null) {
				newPositionOnBoard = GameBoard.LADDERS.get(newPositionOnBoard);
				moveComments.append(" -- LADDER -->");
				moveComments.append(newPositionOnBoard);
			} 
			
			this.setCurrentPlaceOnBoard(newPositionOnBoard);
		}
		
		return moveComments.toString();
	}
	
	public int getCurrentPlaceOnBoard() {
		return currentPlaceOnBoard;
	}

	public void setCurrentPlaceOnBoard(int currentPlaceOnBoard) {
		this.currentPlaceOnBoard = currentPlaceOnBoard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
