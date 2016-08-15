/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_02b;

import java.util.Scanner;
/**
 * Popular casino game called craps.
 * @author AonoZan
 *
 */
public class GameCraps {
	public static Scanner input;
	/**
	 * Method for anouncing if player wins the game.
	 */
	public static void win() {
		System.out.println("You win!"
				+ "\nPress enter to play again."
				+ "\nWrite exit to exit game");
		if (input.nextLine().length() == 0) {
			return;
		} else {
			System.exit(0);
		}
	}
	/**
	 * Method for announcing when player losses game.
	 */
	public static void lose() {
		System.out.println("You lose!"
				+ "\nPress enter to play again."
				+ "\nWrite exit to exit game");
		if (input.nextLine().length() == 0) {
			return;
		} else {
			System.exit(0);
		}
	}
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		Craps craps = new Craps();
		// begin game and ask user to interact
		System.out.println("Let's play a game called craps."
				+ "\nRoll two dices(press enter)... ");
		input.nextLine();
		// loop until game is playing
		while (true) {
			// roll dice first time and notice player
			craps.rollDices();
			System.out.printf("You rolled %d + %d = %d\n",
					craps.getDiceOne(),
					craps.getDiceTwo(),
					craps.getSum()
					);
			// wait for player to interact
			input.nextLine();
			switch (craps.getSum()) {
				case 2:		// if player gets 2, 3 or 12 he loses
					lose();
					break;
				case 3:
					lose();
					break;
				case 12:
					lose();
					break;
				case 7:		// 7 and 11 means win
					win();
					break;
				case 11:
					win();
					break;
				default:	// any other number sets point and game continues
					craps.setPoint();
					// notice player that point is established
					// and wait for him to interact
					System.out.printf("Point is established."
							+ "\nAvoid 7 and try to get %d.\n",
							craps.getPoint());
					input.nextLine();
					do {
						// roll dice until 7 or point is rolled
						craps.rollDices();
						System.out.printf("You rolled %d + %d = %d\n",
								craps.getDiceOne(),
								craps.getDiceTwo(),
								craps.getSum()
								);
						input.nextLine();
					} while (craps.getSum() != 7 && craps.getSum() != craps.getPoint());
					// if player gets 7 he losses
					if (craps.getSum() == 7) {
						lose();
					// or if rolls point he wins
					} else {
						win();
					}
					break;
			}
		}
	}

}
/**
 * Craps class for the game.
 * Rolls dide and holds values of rolled dices.
 * @author AonoZan
 *
 */
class Craps {
	// set minimum and maximum number on dices
	private final int MIN_DICE = 1;
	private final int MAX_DICE = 6;
	// variables for dices, sum and point
	private int diceOne, diceTwo;
	private int sum, point;
	
	Craps () {
	}
	public int getDiceOne() {
		return diceOne;
	}
	public int getDiceTwo() {
		return diceTwo;
	}
	public int getSum() {
		return sum;
	}
	public void setPoint() {
		this.point = this.sum;
	}
	public int getPoint() {
		return this.point;
	}
	/**
	 * Calling this method rolls new dices and sets values.
	 */
	public void rollDices(){
		this.diceOne = MIN_DICE + (int)(Math.random() * MAX_DICE);
		this.diceTwo = MIN_DICE + (int)(Math.random() * MAX_DICE);
		this.sum = this.diceOne + this.diceTwo;
	}
}