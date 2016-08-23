
package projekat_sedmica_03b;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class ConnectFour {
	//create table and store table width and height
	private char[][] table;
	private int tW, tH;
	private int maxTurn, turn = 0;
	// constructor that creates table for desired rows and columns
	public ConnectFour(int rows, int columns) {
		this.tH = rows - 1;
		this.tW = columns - 1;
		this.maxTurn = rows * columns;
		this.table = new char[rows][columns];
	}
	/**
	 * Method for printing table on console.
	 */
	public void printTable() {
		System.out.println("_______________");
		for (char[] chars : table) {
			System.out.print("|");
			for (char ch : chars) {
				if (ch == '\u0000') {
					System.out.print(" ");
				} else {
					System.out.print(ch);
				}
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("'''''''''''''''");
	}
	/**
	 * Make move by placing player on available place on table.
	 * @param player
	 * @param column
	 * @return
	 */
	public boolean makeMove(char player, int column) {
		// loop for every row
		for (int i = table.length - 1; i >= 0; i--) {
			// on first one available place player
			if (table[i][column] == '\u0000') {
				table[i][column] = player;
				this.turn++;
				return true;
			}
		}
		// player wasn't placed
		return false;
	}
	public char winner() {
		// loop for all horizontally places
		// search pattern for 7x5 table length 4
		// vertical horisontal and diagonal
		// ±±±±±±±  ±±±±+++  ±±±±        ±±±±
		// ±±±±±±±  ±±±±+++  ±±±±+      +±±±±
		// ±±±±±±±  ±±±±+++  ±±±±++    ++±±±±
		// +++++++  ±±±±+++   ++++++  ++++++
		// +++++++  ±±±±+++    +++++  +++++
		// +++++++  ±±±±+++     ++++  ++++
		for (int i = 0; i <= this.tH; i++) {
			for (int j = 0; j <= this.tW - 3; j++) {
				// if four places horizontally are equal return player
				if (table[i][j] != '\u0000'
						&& table[i][j] == table[i][j+1]
						&& table[i][j] == table[i][j+2]
						&& table[i][j] == table[i][j+3]) {
					return table[i][j];
				}
			}
		}
		// check for vertical places
		for (int i = 0; i <= this.tW; i++) {
			for (int j = 0; j <= this.tH - 3; j++) {
				// if all four places verticaly are equal return player
				if (table[j][i] != '\u0000'
						&& table[j][i] == table[j+1][i]
						&& table[j][i] == table[j+2][i]
						&& table[j][i] == table[j+3][i]) {
					return table[j][i];
				}
			}
		}
		for (int i = 0; i <= this.tH - 3; i++) {
			for (int j = 0; j <= this.tW - 3; j++) {
				// return player on all four places diagonal(up left to down right)
				if (table[i][j] != '\u0000'
						&& table[i][j] == table[i+1][j+1]
						&& table[i][j] == table[i+2][j+2]
						&& table[i][j] == table[i+3][j+3]) {
					return table[i][j];
				}
			}
		}
		for (int i = 0; i <= this.tH - 3; i++) {
			for (int j = this.tW; j >= 3; j--) {
				// return player on all four places (up right to down left)
				if (table[i][j] != '\u0000'
						&& table[i][j] == table[i+1][j-1]
						&& table[i][j] == table[i+2][j-2]
						&& table[i][j] == table[i+3][j-3]) {
					return table[i][j];
				}
			}
		}
		if (this.turn == this.maxTurn) {
			return 'X';
		}
		return '\u0000';
	}
}

