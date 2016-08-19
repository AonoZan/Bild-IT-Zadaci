
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	public static boolean evenRowCol(int[][] list) {
		int rowSum = -1, colSum = -1;
		int tmpSum;
		for (int i = 0; i < list.length; i++) {
			tmpSum = 0;
			for (int j = 0; j < list[i].length; j++) {
				tmpSum += list[i][j];
			}
			if (rowSum != -1 && rowSum != tmpSum) {
				return false;
			} else {
				rowSum = tmpSum;
			}
			tmpSum = 0;
			for (int j = 0; j < list[i].length; j++) {
				tmpSum += list[j][i];
			}
			if (colSum != -1 && colSum != tmpSum) {
				return false;
			} else {
				colSum = tmpSum;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] matrix = new int[6][6];
		int counter = 0;
		do {
			Zadatak_03.fillList(matrix);
			counter++;
		} while (!evenRowCol(matrix));
//		System.out.println(evenRowCol(matrix));
		System.out.printf("After %d pass first even row and col matrix.\n\n", counter);
		Zadatak_03.printList(matrix);
		
	}

}

