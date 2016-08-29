
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
		System.out.println("\n\n\n\n\n\n\n\n\n");
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
		System.out.println("On map fields marked with:");
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
		//
		int[] legalCol = game.legalColumn(1);
		char rangeFrom = (char)(legalCol[0] + game.MIN_CHAR);
		char rangeTo = (char)(legalCol[1] + game.MIN_CHAR);
		
		for (int i = 0; i < 3; i++) {
			newFrame();
			renderFrame();
			System.out.println("You place ships on right side.");
			System.out.println("You can place on every available row.");
			System.out.printf("You can't place on column which is\nnot in range %c to %c.\n",
					rangeFrom, rangeTo
					);
			System.out.println("Place your 1x3 ship: ");
			String place = input.nextLine();
			boolean placed = game.placeShip(1, place, 3);
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
			// prompt for user character
			System.out.print("Enter field to fire at: ");
			field = input.nextLine();
			
			fired = game.fire(1, field);
			while (!fired) {
				System.out.print("Sorry thets not valid move.\nTry again: ");
				field = input.nextLine();
				fired = game.fire(1, field);
			}
			game.aiFire();
			// try that character in game
//			game.tryLetter(ch);
			
		}
		// print newFrame and render frame
		newFrame();
		renderFrame();
		String winner = game.winner();
		System.out.println("Game over! Winner is " + winner);
		// if user at the end had no lives print he lost game
		// else print he wins
//		if (game.getLives() == 0) {
//			System.out.println("Game Over! You lose!");
//		} else {
//			System.out.println("Congratulation! You win the game!");
//		}
		// print solution
//		System.out.printf("Solution was \"%s\".\n", game.getSolution());
		input.close();
	}

}

class Battleship {
	final int MIN_CHAR = 'A';
	final String PLAYER = "=", COMPUTER = "H", FIRE = "X", MISS = "O";
	private final String EMPTY_FIELD = " ";
	private String[][] map;
	private int mapSize;
	int player1Lives, player2Lives;
	private String mapHeader;
	public Battleship() {
		this(12);
	}
	public Battleship(int mapSize) {
		this.mapSize = mapSize;
		setMap();
		setMapHeader();
		resetLives();
		setComputerShips();
	}
	
	// getters and setters
	public String[][] getWholeMap() {
		return this.map;
	}
	
	// default setters
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
	private void setComputerShips() {
		int[] legalCol = legalColumn(2);
		for (int i = 0; i < 3; i++) {
			int row = (int)(Math.random() * this.mapSize);
			int col = legalCol[0] + (int)(Math.random() * legalCol[1] - legalCol[0]);
			String place = new String(row + "" + (char)(col + MIN_CHAR));
			boolean placed = placeShip(2, place, 3);
			if (!placed) i--;
		}
	}
	private void resetLives() {
		this.player2Lives = 9;
		this.player1Lives = 9;
	}
	
	private boolean available(int row, int col, int size) {
		if (row >= map.length) return false;
		if (col + size > map.length) return false;
		for (int i = col; i < size; i++) {
			if (this.map[row][i] == PLAYER
					|| this.map[row][i] == COMPUTER) return false;
		}
		return true;
	}
	public int[] legalColumn(int player) {
		if (player < 1 || player > 2) return null;
		int[] range = new int[2];
		if (player == 1) {
			range[0] = this.mapSize / 2 + this.mapSize % 2;
			range[1] = this.mapSize - 3;
		} else if (player == 2){
			range[0] = 0;
			range[1] = this.mapSize / 2 - 3;
		}
		return range;
	}
	private int[] processInput(String input) {
		int[] indexes;
		int row = 0, col = 0;
		int lastChar = input.length() - 1;
		try {
			row = Integer.parseInt(input.substring(0, lastChar));
			
			char column = input.charAt(lastChar);
			if (Character.isAlphabetic(column) && Character.isUpperCase(column)) {
				col = column - MIN_CHAR;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		indexes = new int[] {row, col};
		return indexes;
	}
	public boolean aiFire() {
		int range = this.mapSize / 2;
		
		while (true) {
			int row = (int)(Math.random() * this.mapSize);
			int col = range + (int)(Math.random() * range + this.mapSize % 2);
			
			if (this.map[row][col] != EMPTY_FIELD
					&& this.map[row][col] != PLAYER) {
				continue;
			}
			String place = new String(row + "" + (char)(col + MIN_CHAR));
			fire(2, place);
			break;
		}
		return true;
	}
	public boolean fire(int player, String field) {
		int[] indexes = processInput(field);
		if (indexes == null) return false;
		if (indexes[1] < 0 || indexes[1] > mapSize) {
			return false;
		}
		String place = this.map[indexes[0]][indexes[1]];
		if (place.equals(PLAYER) || place.equals(COMPUTER)) {
			this.map[indexes[0]][indexes[1]] = FIRE;
			if (player == 1) {
				player2Lives--;
			} else {
				player1Lives--;
			}
		} else if (place.equals(EMPTY_FIELD)){
			this.map[indexes[0]][indexes[1]] = MISS;
		}
		return true;
	}
	public boolean placeShip(int player, String place, int size) {
		int[] indexes = processInput(place);
		int[] legal = legalColumn(player);
		if (indexes == null) return false;
		int row = indexes[0];
		int col = indexes[1];
		if (col < legal[0] || col > legal[1]) return false;
		System.out.println(row + " " + col);
		System.out.println(legal[0] + " " + legal[1]);
		if (!available(row, col, size)) return false;
		for (int i = 0; i < size; i++) {
			if (player == 1) {
				this.map[row][col + i] = PLAYER;
			} else {
				this.map[row][col + i] = COMPUTER;
			}
			System.out.println("avai");
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