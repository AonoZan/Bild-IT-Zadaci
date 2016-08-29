
package projekat_sedmica_04a;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Launcher for game called "hangman".
 * 
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class App {
	// global reference to the game
	private static Vjesalica game;
	
	/**Method serves as new frame, prints bunch of new lines.*/
	private static void newFrame() {
		System.out.println("\n\n\n\n\n\n\n\n\n");
	}
	/**Method renders status of the game. (picture, word, lives...)*/
	private static void renderFrame() {
		// render hangman picture
		System.out.print(String.format(game.getPicture()));
		System.out.println(game.getWord());
		System.out.println("Lives: " + game.getLives());
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// initialize default game
		game = new Vjesalica();
		// print welcome screen and quick help, wait for response
		System.out.println("Let's play game called hangman.");
		System.out.println("Computer has picked random word and\nyou need to guess it.");
		System.out.println("Type in character which you think it's in word.");
		System.out.println("Game ends when you figure word or lose all your lives.\n");
		System.out.println("Press enter to continue...");
		input.nextLine();
		
		// newFrame and ask user for difficulty level
		newFrame();
		while (true) {
			try {
				// prompt for number
				System.out.println("Set difficulty (1, 2, 3): ");
				int difficulty = input.nextInt();
				// if it's input is 1, 2 or 3
				if (difficulty >= 1 && difficulty <= 3) {
					// set difficulty and break
					switch (difficulty) {
					case 1:
						game.setLives(Vjesalica.LIVES_EASY);
						break;
					case 2:
						game.setLives(Vjesalica.LIVES_MEDIUM);
						break;
					case 3:
						game.setLives(Vjesalica.LIVES_HARD);
						break;
					default:
						break;
					}
				// not correct try again...
				} else {
					System.out.println("Please enter 1, 2 or 3 for difficulty...");
					continue;
				}
				// difficulty set clear input and break
				input.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		// enter main game loop until game is over
		while (!game.gameOver()) {
			// new frame and render frame
			newFrame();
			renderFrame();
			// prompt for user character
			System.out.print("Enter char: ");
			char ch = input.nextLine().charAt(0);
			// try that character in game
			game.tryLetter(ch);
			
		}
		// print newFrame and render frame
		newFrame();
		renderFrame();
		// if user at the end had no lives print he lost game
		// else print he wins
		if (game.getLives() == 0) {
			System.out.println("Game Over! You lose!");
		} else {
			System.out.println("Congratulation! You win the game!");
		}
		// print solution
		System.out.printf("Solution was \"%s\".\n", game.getSolution());
		input.close();
	}

}
/**Simple hangman game class.*/
class Vjesalica {
	// constant for setting game lives
	public static final int LIVES_EASY = 7;
	public static final int LIVES_MEDIUM = 5;
	public static final int LIVES_HARD = 3;
	// actual random picked word and user inputed characters (log)
	private String word;
	private String letterLog = "";
	// boolean list for marking discovered characters and default amount of lives
	private boolean[] wordMask;
	private int lives = LIVES_EASY;
	// word list
	private String[] wordList = new String[] {
			"banana", "jabuka", "kruska", "sljiva",
			"orah", "cvekla", "rotkva", "mrkva"
	};
	// stickman assembly parts,
	// strings on odd places are for actual picture of hangman
	// on even places are blank picture parts
	// game picks blank if player have lives if not stickman is rendered
	private String[] stickMan = new String[] {
			"  |   /'\\\n  |   \\_/\n", "  |       \n  |       \n",
			"  |  --", "  |    ", "|--\n", "\n",
			"  |    |\n", "  |     \n", "  |   / ", "  |     ", "\\   ", "    "
	};
	// create default game
	Vjesalica() {
		setWord();
		setWordMask();
	}
	/**Method sets new random word for game.*/
	private void setWord() {
		// get random index based on word list size and pick word
		int randIndex = (int)(Math.random() * wordList.length);
		this.word = wordList[randIndex];
	}
	// create word mask list based on current word length
	private void setWordMask() {
		this.wordMask = new boolean[this.word.length()];
	}
	// set lives for player
	public void setLives(int lives) {
		// if wrong argument set lives to default value
		if (lives < 0 || lives > 7) {
			this.lives = LIVES_EASY;
		}
		this.lives = lives;
	}
	// get solution for the end of the game
	public String getSolution() {
		return this.word;
	}
	// get current amount of lives player have
	public int getLives() {
		return this.lives;
	}
	/**Method retrieves stickman picture.*/
	public String getPicture() {
		// get amount of lives used
		int lives = LIVES_EASY - this.lives;
		StringBuffer buffer = new StringBuffer("  '''''|\n");
		// go trough stickman assembly string and iterate by 2
		for (int i = 0; i < stickMan.length; i+=2) {
			// for every lost life add stickman part
			if (lives > 0) {
				lives--;
				buffer.append(stickMan[i]);
			// else empty part 
			} else {
				buffer.append(stickMan[i+1]);
			}
		}
		return buffer.toString();
		
		
	}
	/**Get word with hidden characters if not discovered.*/
	public String getWord() {
		// create buffer
		StringBuffer buffer = new StringBuffer(".");
		// loop trough word
		for (int i = 0; i < word.length(); i++) {
			// add character if discovered
			if (wordMask[i]) {
				buffer.append(word.charAt(i));
			// else add blank character
			} else {
				buffer.append("_");
			}
			buffer.append(".");
		}
		return buffer.toString();
	}
	/**Process user input and mark character if found.*/
	public boolean tryLetter(char letter) {
		// found is false by default
		boolean found = false;
		// loop trough word
		for (int i = 0; i < word.length(); i++) {
			// if found character unveil mask for that character and set found
			if (word.charAt(i) == letter) {
				found = true;
				this.wordMask[i] = true;
			}
		}
		// if not found and not guessed early(in log) lose game life
		if (!found && !letterLog.contains(letter+"")) {
			this.lives--;
		}
		// add user character to log 
		letterLog += letter;
		return found;
	}
	/**Method returns true if game ended.*/
	public boolean gameOver() {
		// create boolean for mask
		boolean mask = true;
		// go trough mask and see if any unveiled character
		for (boolean m : wordMask) {
			if (!m) mask = false;
		}
		// if all unveiled characters or no lives game is over
		if (mask || this.lives == 0) {
			return true;
		}
		// game is not over in any other case
		return false;
	}
}
