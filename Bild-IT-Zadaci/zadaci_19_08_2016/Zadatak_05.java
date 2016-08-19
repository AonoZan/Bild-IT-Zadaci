
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method for checking if all rows and columns have same sum of values.
	 * @param list
	 * @return
	 */
	public static boolean evenRowCol(int[][] list) {
		// variables for row, col and tmp sum 
		int rowSum = -1, colSum = -1;
		int tmpSum;
		// loop over list
		for (int i = 0; i < list.length; i++) {
			// reset temporary sum
			tmpSum = 0;
			// sum row in to temporary sum var
			for (int j = 0; j < list[i].length; j++) {
				tmpSum += list[i][j];
			}
			// if row sum is not on default and not equal to tmp return false
			if (rowSum != -1 && rowSum != tmpSum) {
				return false;
			// else if on default set new value
			} else {
				rowSum = tmpSum;
			}
			// reset temporary sum
			tmpSum = 0;
			// sum columns in to temporary sum
			for (int j = 0; j < list[i].length; j++) {
				tmpSum += list[j][i];
			}
			// if column sum is not on default and not equal to temp return sum
			if (colSum != -1 && colSum != tmpSum) {
				return false;
			// if column sum on default set new value
			} else {
				colSum = tmpSum;
			}
		}
		return rowSum == colSum ? true : false;
	}
	/**
	 * Program creates new 6x6 matrix and loops to find matrix
	 * with equal row and columns values.
	 * @param args
	 */
	public static void main(String[] args) {
		// create matrix and counter to store all passes
		int[][] matrix = new int[6][6];
		int counter = 0;
		// loop until even row and column matrix is found
		do {
			Zadatak_03.fillList(matrix);
			counter++;
		} while (!evenRowCol(matrix));
		// print status and matrix
		System.out.printf("After %d pass first even row and col matrix.\n\n", counter);
		Zadatak_03.printList(matrix);
		
	}

}

