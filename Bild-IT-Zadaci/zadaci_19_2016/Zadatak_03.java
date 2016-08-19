
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Mrthod for filling matrix with values.
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
	public static void printList(int[] list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
	public static void printList(int[][] list) {
		for (int[] is : list) {
			printList(is);
			System.out.println();
		}
	}
	/**
	 * Methos sums list of integers.
	 * @param list
	 * @return
	 */
	public static int sum(int[] list) {
		// if 
		if (list == null) return 0;
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
	public static int[] greatestElement(int[][] list) {
		if (list == null) return null;
		int row = 0, col = 0;
		int rowSum = 0, colSum = 0;
		int tmp = 0;
		int[] tmpCol = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			tmp = sum(list[i]);
			if (tmp > rowSum) {
				rowSum = tmp;
				row = i;
			}
			for (int j = 0; j < tmpCol.length; j++) {
				tmpCol[j] = list[j][i];
			}
			tmp = sum(tmpCol);
			if (tmp > colSum) {
				colSum = tmp;
				col = i;
			}
		}
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

