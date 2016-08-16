package zadaci_15_08_2016;
import java.util.Scanner;

/**
 * @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	private static Scanner input;
	/**
	 * Method for main game loop.
	 * Two variables are used and to check who wins, computer or player.
	 * At the end method asks if player wants to play more.
	 * @param userPlay
	 * @param compPlay
	 * @return true if player wants to play more else false.
	 */
	public static boolean gamePlays(int userPlay, int compPlay) {
		switch (userPlay) {
		case 0: // when user plays rock
			System.out.println("User plays rock.");
			if (compPlay == 1) {
				System.out.println("Computer plays scissors.");
				System.out.println("User won!");
			} else if (compPlay == 2) {
				System.out.println("Computer plays paper.");
				System.out.println("Computer won!");
			} else {
				System.out.println("Both user and computer played rock.");
				System.out.println("It's a draw!");
			}
			break;
		case 1: // when user plays scissors
			System.out.println("User plays scissors.");
			if (compPlay == 2) {
				System.out.println("Computer plays paper.");
				System.out.println("User won!");
			} else if (compPlay == 0) {
				System.out.println("Computer plays rock.");
				System.out.println("Computer won!");
			} else {
				System.out.println("Both user and computer played scissors.");
				System.out.println("It's a draw!");
			}
			break;
		case 2: // when user plays paper
			System.out.println("User plays paper.");
			if (compPlay == 0) {
				System.out.println("Computer plays rock.");
				System.out.println("User won!");
			} else if (compPlay == 1) {
				System.out.println("Computer plays scissors.");
				System.out.println("Computer won!");
			} else {
				System.out.println("Both user and computer played paper.");
				System.out.println("It's a draw!");
			}
			break;
		default: // when user plays any other number
			System.out.println("Invalid input try again.");
			break;
		}
		// ask user if game should continue
		System.out.println("Care to play again? (Y/N)");
		return input.nextLine().charAt(0) == 'y' ? true : false;
	}
	/**
	 * Popular game rock-scissors-paper.
	 * @param args
	 */
	public static void main(String[] args) {
		// constant for three computer choices rock, scissors and paper
		final int ROCK_SCISS_PAPER = 3;
		// variables for both user and computer choices
		int userPlays = -1, compPlays = -1;
		// variables that is true as long as games plays
		boolean play = true;
		
		input = new Scanner(System.in);
		// start game by printing rules
		System.out.println("Let's play rock-scissors-paper!");
		System.out.println("0 for rock,"
				+ "1 for scissors and"
				+ "2 for paper");
		// play game until "play" is true
		do {
			// do computer choice
			compPlays = (int)(Math.random() * ROCK_SCISS_PAPER);
			// get user choice
			System.out.println("You playing? ");
			userPlays = input.nextInt();
			// clear line
			input.nextLine();
			System.out.println(userPlays + " "+compPlays);
			// announce who wins and get boolean for game
			play = gamePlays(userPlays, compPlays);
		} while (play);
	}

}
