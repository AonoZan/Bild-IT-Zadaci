
package projekat_sedmica_04b;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class App {
	// global reference to the game
	private static Battleship game;
	
	/**Method serves as new frame, prints bunch of new lines.*/
	private static void newFrame() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	/**Method renders status of the game. (picture, word, lives...)*/
	private static void renderFrame() {
		// render battlefield map
		System.out.println(game.getMap(game.getWholeMap()));
	}
	/**Main method of game battleship.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean fired;
		String field;
		
		newFrame();
		// print welcome screen and quick help, wait for response
		System.out.println("Let's play game called battleship.");
		System.out.println("Computer and player place their ships on to battlefield.");
		System.out.println("Player and coumputer then each take turns\nand fire cannons on map fields.");
		System.out.println("On map, fields marked with:");
		System.out.println("\t\"O\" are places where player or computer missed");
		System.out.println("\t\"X\" where player or computer hit opponent ship\n");
		System.out.println("Press enter to continue...");
		input.nextLine();
		
		newFrame();
		// Get size of the map from player
		while (true) {
			int size = 0;
			try {
				// prompt for size
				System.out.println("Enter map size or 0 for default: ");
				size = input.nextInt();
				input.nextLine(); // clear console immediately
			} catch (InputMismatchException e) {
				// if user enters wrong input clear it
				System.out.println("Please enter number as size.");
				input.nextLine();
			}
			// if size is less than minimum use default
			if (size < 7) {
				// initialize default game
				game = new Battleship();
			} else {
				game = new Battleship(size);
			}
			break;
		}
		// get legal columns for ship placement
		int[] legalCol = game.legalColumn(1);
		// convert legal placement to chars
		char rangeFrom = (char)(legalCol[0] + game.MIN_CHAR);
		char rangeTo = (char)(legalCol[1] + game.MIN_CHAR);
		// ask player to place 3 ships
		for (int i = 1; i <= 3; i++) {
			newFrame();
			renderFrame();
			System.out.println("Place ship no. " + i);
			System.out.println("You place ships on right side.");
			System.out.println("You can place on every available row.");
			System.out.println("Correct place would be 0B or 12V for example...");
			System.out.printf("You can't place on column which is\nnot in range %c to %c.\n",
					rangeFrom, rangeTo
					);
			System.out.println("Place your 1x3 grid ship: ");
			String place = input.nextLine();
			// try to place ship 3 blocks wide on place
			boolean placed = game.placeShip(1, place, 3);
			// if not placed print message, wait input
			if (!placed) {
				System.out.println();
				System.out.println("Sorry thats not rigth place.");
				System.out.println("Press enter to continue...");
				i--;
				input.nextLine();
			}
		}
		
		// enter main game loop until game is over
		while (!game.gameOver()) {
			// new frame and render frame
			newFrame();
			renderFrame();
			// prompt for user for field to fire at and try to fire
			System.out.print("Enter field to fire at: ");
			field = input.nextLine();
			fired = game.fire(1, field);
			// if couldn't fire at that place loop until finally correctly fired
			while (!fired) {
				System.out.print("Sorry thets not valid move.\nTry again: ");
				field = input.nextLine();
				fired = game.fire(1, field);
			}
			// let computer fire
			game.aiFire();
			
		}
		// print newFrame and render frame
		newFrame();
		renderFrame();
		// get winner of the game and print it
		String winner = game.winner();
		System.out.println("Game over! Winner is " + winner);
		input.close();
	}

}
/**Battleship game class.*/
class Battleship {
	// constant for min character and map place types
	final int MIN_CHAR = 'A';
	final String PLAYER = "=", COMPUTER = "H", FIRE = "X", MISS = "O";
	private final String EMPTY_FIELD = " ";
	// map and map size
	private String[][] map;
	private int mapSize;
	// variable that store players lives
	int player1Lives, player2Lives;
	// header for the map
	private String mapHeader;
	// default game constructor creates map with size 12x12
	public Battleship() {
		this(12);
	}
	public Battleship(int mapSize) {
		this.mapSize = mapSize;
		setMap();			// set map with blank places
		setMapHeader();		// create header once
		resetLives();		// set default number of lives for each player
		setComputerShips();	// let computer place ships on it's side
	}
	
	// getters and setters
	public String[][] getWholeMap() {
		return this.map;
	}
	/**Create map and fill with empty fields.*/
	private void setMap() {
		this.map = new String[mapSize][mapSize];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = EMPTY_FIELD;
			}
		}
	}
	/**Setups map header (letters for position)*/
	private void setMapHeader() {
		// create buffer
		StringBuilder buffer = new StringBuilder("    ");
		// loop from character A to Z and add map size letters to the header
		for (int i = MIN_CHAR; i < map.length + MIN_CHAR; i++) {
			buffer.append((char)(i) + EMPTY_FIELD);
		}
		buffer.append("\n");
		this.mapHeader = buffer.toString();
	}
	/**Method that sets computer ships on left side.*/
	private void setComputerShips() {
		// get legal columns where computer can place ships 1x3 size
		int[] legalCol = legalColumn(2);
		// place 3 ships
		for (int i = 0; i < 3; i++) {
			// create random row and column and convert to "place" (for example 5A)
			int row = (int)(Math.random() * this.mapSize);
			int col = legalCol[0] + (int)(Math.random() * legalCol[1] - legalCol[0]);
			String place = new String(row + "" + (char)(col + MIN_CHAR));
			// try to place and if not successful loop back
			boolean placed = placeShip(2, place, 3);
			if (!placed) i--;
		}
	}
	/**Method resets players lives to default state.*/
	private void resetLives() {
		this.player2Lives = 9;
		this.player1Lives = 9;
	}
	/**Method checks if place is available for 1x3 ship*/
	private boolean available(int row, int col, int size) {
		// if wrong row or column return false
		if (row >= map.length
			|| col + size > map.length) return false;
		// loop to size of the ship and check if available
		for (int i = col; i < size; i++) {
			// if something is on place return false
			if (this.map[row][i] == PLAYER
					|| this.map[row][i] == COMPUTER) return false;
		}
		return true;
	}
	/**Method returns legal columns for ship placement for certain player.*/
	public int[] legalColumn(int player) {
		// if not correct player return null
		if (player < 1 || player > 2) return null;
		// create list for legal column range
		int[] range = new int[2];
		// calculate legal columns for each player and based on it's side
		if (player == 1) {
			range[0] = this.mapSize / 2 + this.mapSize % 2;
			range[1] = this.mapSize - 3;
		} else if (player == 2){
			range[0] = 0;
			range[1] = this.mapSize / 2 - 3;
		}
		return range;
	}
	/**Method processes player input. For example converts 0A place to (0, 0) index.*/
	private int[] processInput(String input) {
		// create list for indexes and valiable to store them
		int[] indexes;
		int row = 0, col = 0;
		// setup last char position to deal with multiple digit numbers
		int lastChar = input.length() - 1;
		try {
			// try to get number and char from input
			row = Integer.parseInt(input.substring(0, lastChar));
			char column = input.charAt(lastChar);
			// check if character is valid and convert it to index
			if (Character.isAlphabetic(column) && Character.isUpperCase(column)) {
				col = column - MIN_CHAR;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		// add indexes to the list and return it
		indexes = new int[] {row, col};
		return indexes;
	}
	/**Method serves for computer move. */
	public boolean aiFire() {
		// computer has range on right side of the map (players side)
		int range = this.mapSize / 2;
		// loop until corect field is found
		while (true) {
			// generate random row and column index
			int row = (int)(Math.random() * this.mapSize);
			int col = range + (int)(Math.random() * range + this.mapSize % 2);
			// computer should only fire at empty places or places where player ship is
			if (this.map[row][col] != EMPTY_FIELD
					&& this.map[row][col] != PLAYER) {
				continue;
			}
			// create place for method and fire at that place
			String place = new String(row + "" + (char)(col + MIN_CHAR));
			fire(2, place);
			break;
		}
		return true;
	}
	/**
	 * Method serves for player or computer move.
	 * At each turn player and computer fire at map with this method.
	 * Method change map field to 'X' if hit something or 'O' if miss.
	 */
	public boolean fire(int player, String field) {
		// create indexes
		int[] indexes = processInput(field);
		// if wrong input return false which means not fired
		if (indexes == null) return false;
//		// if user indexes out of range return not fired
		if (indexes[0] < 0 || indexes[0] >= mapSize
			|| indexes[1] < 0 || indexes[1] >= mapSize) {
			return false;
		}
		// get place from map based on indexes
		String place = this.map[indexes[0]][indexes[1]];
		// if place contains someone ship destroy it
		if (place.equals(PLAYER) || place.equals(COMPUTER)) {
			this.map[indexes[0]][indexes[1]] = FIRE;
			// destroys opponent life
			if (player == 1) {
				player2Lives--;
			} else {
				player1Lives--;
			}
		// if it's empty field mark as miss
		} else if (place.equals(EMPTY_FIELD)){
			this.map[indexes[0]][indexes[1]] = MISS;
		}
		return true;
	}
	/**Method places ship on the map.*/
	public boolean placeShip(int player, String place, int size) {
		// get user input indexes and legal columns
		int[] indexes = processInput(place);
		int[] legal = legalColumn(player);
		// if wrong input indexes return not placed
		if (indexes == null) return false;
		// get row and column
		int row = indexes[0];
		int col = indexes[1];
		// check if legal column and if place is available for whole 1x3 ship
		if (col < legal[0] || col > legal[1]) return false;
		if (!available(row, col, size)) return false;
		// if available write ship to the map
		for (int i = 0; i < size; i++) {
			// if player 1 played write players ship else computer ship
			if (player == 1) {
				this.map[row][col + i] = PLAYER;
			} else {
				this.map[row][col + i] = COMPUTER;
			}
		}
		return true;
	}
	/**Get map row with player moves and ships*/
	private String getMapRow(String[] mapRow) {
		StringBuilder buffer = new StringBuilder("|");
		// go trough whole row
		for (String field : mapRow) {
			// if only row contains computer ship hide it by appending empty field
			if (field.equals(COMPUTER)) {
				buffer.append(EMPTY_FIELD);
			// else append that field
			} else {
				buffer.append(field);
			}
			// append spacer
			buffer.append("|");
		}
		return buffer.toString();
	}
	/**Assemble whole map.*/
	public String getMap(String[][] map) {
		// create buffer and add map header
		StringBuilder buffer = new StringBuilder(this.mapHeader);
		// create index for counting rows
		int row = 0;
		for (String[] mapRow : map) {
			// add row count and row
			buffer.append(String.format("%2s ", row));
			buffer.append(getMapRow(mapRow));
			buffer.append("\n");
			row++;
		}
		return buffer.toString();
	}
	/**Get winner of the game.*/
	public String winner() {
		// if both player lost lives return draws else return winner
		if (player1Lives == 0 && player2Lives == 0) {
			return "draws";
		} else if (player2Lives == 0) {
			return "player";
		} else if (player1Lives == 0){
			return "computer";
		}
		// players have lives game has no winner
		return "no one";
		
	}
	/**return true if game ended.*/
	public boolean gameOver() {
		// if any of the players lose their lives game ends
		if (player1Lives == 0 || player2Lives == 0) return true;
		// else game runs
		return false;
	}
}