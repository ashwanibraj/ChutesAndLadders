package com.ashwani.chutesLadders;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashwani Braj
 */
public class Game {
	private List<Player> players = new ArrayList<Player>();
	private int moveCount = 0;
	
	public Game(List<Player> players) {
		this.players = players;
	}

	/**
	 * Reference 	- Refer to "How to play" point 1. An initial spin score will determine play sequence of players.
	 * Description 	- This method arranges Players by their spinner score in descending order.
	 * 					The player with highest spinner score goes first. 
	 * Assumption	- Instead of proceeding play to the left (refer requirement doc), this method ensures play proceeds in reverse order of initial spin.
	 */
	public void arrangePlayerSequence() {
		players.sort((Player p1, Player p2) -> {
			return p2.spinTheSpinner() - p1.spinTheSpinner();
		});
	}
	
	public void play() {
		boolean isThereAWinnerYet = false;
		while(! isThereAWinnerYet) {
			for(Player player: players) {
				moveCount += 1;
				String moveComment = player.makeNextMove(player.spinTheSpinner());
				Game.displayComment(this.moveCount + ": " + moveComment);
				if(player.getCurrentPlaceOnBoard() == GameBoard.WINNING_SQUARE) {
					isThereAWinnerYet = true;
					Game.displayComment("The winner is " + player.getName()+"!");
					break;
				}
			}
		}
	}
	
	static void displayComment(String comment) {
		System.out.println(comment);
	}
}
