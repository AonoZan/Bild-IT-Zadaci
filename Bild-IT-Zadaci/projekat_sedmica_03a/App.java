
package projekat_sedmica_03a;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class App {

	public static void main(String[] args) {
		TicTacTable table = new TicTacTable();
		table.makeMove(1, 1);
		table.makeMove(2, 1);
		table.makeMove(4, 1);
		table.makeMove(7, 1);
		table.printTable();
	}

}
/**
 * 123
 * 456
 * 789
 * 147
 * 258
 * 369
 * 159
 * 357
 * 
 * @author AonoZan
 *
 */
class TicTacTable {
	private String player1 = "X";
	private String player2 = "O";
	private Place[][] ticPaths = new Place[8][3];
	
	public TicTacTable() {
		 refilTable();
	}
	public void makeMove(int place, int player) {
		if (player == 1) {
			ticPaths[(place-1)/3][(place-1)%3].setValue(player1);
		}else if (player == 2) {
			ticPaths[(place-1)/3][(place-1)%3].setValue(player2);
		}
	}
	
	public void printTable() {
		// for all rows eg. combination of 123
		for (int i = 0; i < ticPaths.length; i++) {
			for (int j = 0; j < ticPaths[i].length; j++) {
				System.out.print(ticPaths[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
	/**
	 * Construct table of combinations.
	 * for table that looks like this:
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * Player 1 wins if he fills for example 123 places.
	 * This method constructs all possible combination
	 * that player can fill to win.
	 */
	private void refilTable() {
		// for row combinations
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < ticPaths[0].length; j++) {
				ticPaths[i][j] = new Place();
			}
		}
		// copy places into vertical combinations
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < ticPaths[0].length; j++) {
				ticPaths[i][j] = ticPaths[j][i-3];
			}
		}
		// and copy places into narrow combinations
		for (int j = 0; j < 3; j++) {
			ticPaths[6][j] = ticPaths[j][j];
			ticPaths[7][j] = ticPaths[j][2-j];
		}
	}
	
}
class Place {
	String value;
	public Place() {
		this(null);
	}
	public Place(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}