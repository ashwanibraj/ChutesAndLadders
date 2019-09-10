/**
 * 
 */
package com.ashwani.chutesLadders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ashwani Braj
 *
 */
public class ChutesAndLadder {
	Scanner scannerInput = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChutesAndLadder chutesAndLadders = new ChutesAndLadder();
		int numPlayers = chutesAndLadders.getNumberOfPlayers();
		
		if(! chutesAndLadders.isNumberOfPlayersValid(numPlayers)) {
			System.out.println("Number of players must be 2, 3 or 4. Please try again.");
			return;
		}
		
		List<Player> players = chutesAndLadders.registerPlayers(numPlayers);
		
		Game game = new Game(players);
		
		game.arrangePlayerSequence();
		
		game.play();
	}
	
	private int getNumberOfPlayers() {
		try {
			System.out.print("Enter number of players between 2 and 4: ");
			int input = Integer.parseInt(scannerInput.nextLine());
			return input;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}
		return -1;
	}
	
	private boolean isNumberOfPlayersValid(int numPlayers) {
		if(numPlayers < 2 || numPlayers > 4)
			return false;
		return true;
	}
	
	private List<Player> registerPlayers(int numPlayers) {
		List<Player> players = new ArrayList<Player>();
		for(int i=0; i< numPlayers; i++) {
			System.out.printf("Enter name of player %d: ", i+1);
			String name = scannerInput.nextLine();
			players.add(new Player(name));
		}
		
		return players;
	}

}
