
package projekat_sedmica_03b;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class ConnectFour {
	private String[][] table;
	// constructor that creates table for desired rows and columns
	public ConnectFour(int rows, int columns) {
		this.table = new String[rows][columns];
	}
	public void printTable() {
		System.out.println("");
		for (String[] strings : table) {
			System.out.print("|");
			for (String string : strings) {
				if (string == null) {
					System.out.print(" ");
				} else {
					System.out.print(string);
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
	/**
	 * Make move by placing player on available place on table.
	 * @param player
	 * @param column
	 * @return
	 */
	public boolean makeMove(String player, int column) {
		// loop for every row
		for (int i = table.length - 1; i <= 0; i++) {
			// on first one available place player
			if (table[i][column] == null) {
				table[i][column] = player;
				return true;
			}
		}
		// player wasn't placed
		return false;
	}
}

