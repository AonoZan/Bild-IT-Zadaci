
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Method for filling matrix with values.
	 * @param list
	 * @return
	 */
	public static void fillList(int[][] list){
		// for each row
		for (int i = 0; i < list.length; i++) {
			// for each column in row
			for (int j = 0; j < list[i].length; j++) {
				// fill value with 0 or 1
				list[i][j] = (int)(Math.random() * 2);
			}
		}
	}
	/**
	 * Method prints list of elements.
	 * @param list
	 */
	public static void printList(int[] list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
	/**
	 * Method prints 2D list.
	 * @param list
	 */
	public static void printList(int[][] list) {
		for (int[] is : list) {
			printList(is);
			System.out.println();
		}
	}
	/**
	 * MethoD sums list of integers.
	 * @param list
	 * @return
	 */
	public static int sum(int[] list) {
		// if wrong argument return 0
		if (list == null) return 0;
		// go trough list elements and add to sum values
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		// return sum
		return sum;
	}
	/**
	 * Method for finding greatest element in list.
	 * @param list
	 * @return
	 */
	public static int[] greatestElement(int[][] list) {
		// for bad argument return null
		if (list == null) return null;
		int row = 0, col = 0;		// variables for each index
		int rowSum = 0, colSum = 0;	// variables for sum of rows and columns
		int tmp = 0;				// temporary variable for sum
		// temporary list of column values
		int[] tmpCol = new int[list.length];
		// go trough list
		for (int i = 0; i < list.length; i++) {
			// get sum of row elements
			tmp = sum(list[i]);
			// if sum of row is bigger update index and biggest sum
			if (tmp > rowSum) {
				rowSum = tmp;
				row = i;
			}
			// fill column elements in to temp list
			for (int j = 0; j < tmpCol.length; j++) {
				tmpCol[j] = list[j][i];
			}
			// get sum of column elements
			tmp = sum(tmpCol);
			// if sum of column is greater update index and greatest sum
			if (tmp > colSum) {
				colSum = tmp;
				col = i;
			}
		}
		// return list of row and column indexes
		return new int[]{row, col};
	}
	/**
	 * Program creates and prints 4x4 matrix.
	 * Using method greatestElement() program finds largest row and column
	 * and then prints it on console.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// create list of 4x4
		int[][] list = new int[4][4];
		// fill list with random values and print it
		fillList(list);
		printList(list);
		// find row and column indexes and print them on console
		int[] rowCol = greatestElement(list);
		System.out.println("The largest row index: " + rowCol[0]);
		System.out.println("The largest column index: " + rowCol[1]);
	}

}

