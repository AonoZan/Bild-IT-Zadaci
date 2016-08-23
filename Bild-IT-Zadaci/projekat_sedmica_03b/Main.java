
package projekat_sedmica_03b;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Main {
	
	static Scanner input;
	/**
	 * Method for clearing console and waiting until user makes action.
	 */
	public static void waitResponse(){
		System.out.println("Press enter...");
		input.nextLine();
		input.nextLine();
	}
	/**
	 * Program is well known game "connect four".
	 * Rules are that each player takes turns and board is filled
	 * with players discs blue or red ones(B or R).
	 * winner is player who manages to place four in a row
	 * horizontally, vertically or diagonally.
	 * @param args
	 */
	public static void main(String[] args) {
		input = new Scanner(System.in);
		// create game with 6x7 table
		ConnectFour game = new ConnectFour(6, 7);
		// boolean for turns
		boolean playerTurn = true;
		// players signatures
		char player1 = 'B', player2 = 'R';
		// current player and winning player
		char player, winner = '\u0000';
		int inputNum = 0;
		// play until game breaks
		do {
			// print table
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			game.printTable();
			// try to place players disc on the table
			try {
				// set correct player based on turn and prompt player too play
				player = playerTurn ? player1 : player2;
				System.out.printf("Drop a %s disk at column (0–6): ", playerTurn ? "blue" : "red");
				inputNum = input.nextInt();
				// if incorrect column loop again after user action
				if (inputNum > 6 || inputNum < 0) {
					System.out.println("Please enter value between 0 a0nd 6.");
					waitResponse();
					continue;
				}
				// if player tried to play on column that's full loop again
				if (!game.makeMove(player, inputNum)) {
					System.out.println("That collumn is full.");
					waitResponse();
					continue;
				}
				// get winner and if it's not empty break of the game
				winner = game.winner();
				if (winner != '\u0000') {
					break;
				}
				// switch turn for next player
				playerTurn = !playerTurn;
				
			} catch (InputMismatchException e){
				System.out.println("Please enter only numbers.");
				input.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			
		} while (true);
		// print table after game finishes
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		game.printTable();
		// and print status of who won the game
		System.out.println("Game over.");
		if (winner == 'X') {
			System.out.println("It's a draw!");
		} else {
			System.out.printf("Winner is %s player!\n", playerTurn ? "blue" : "red");
		}
		input.close();
	}

}

