
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Method returns sum of all elements in list.
	 * @param list
	 * @return
	 */
	public static int sum(int[] list) {
		if (list == null) return 0;
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
	/**
	 * Program calculates sum of weekly hours for eight employees and display's
	 * data in decreasing order.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] emlpyee0 = new int[] {2, 4, 3, 4, 5, 8, 8};
		int[] emlpyee1 = new int[] {7, 3, 4, 3, 3, 4, 4};
		int[] emlpyee2 = new int[] {3, 3, 4, 3, 3, 2, 2};
		int[] emlpyee3 = new int[] {9, 3, 4, 7, 3, 4, 1};
		int[] emlpyee4 = new int[] {3, 5, 4, 3, 6, 3, 8};
		int[] emlpyee5 = new int[] {3, 4, 4, 6, 3, 4, 4};
		int[] emlpyee6 = new int[] {3, 7, 4, 8, 3, 8, 4};
		int[] emlpyee7 = new int[] {6, 3, 5, 9, 2, 7, 9};
		
		int[][] sumOfHours = new int[8][2];
		for (int i = 0; i < sumOfHours.length; i++) {
			sumOfHours[0][0] = i;
			sumOfHours[0][1] = i;
		}
	}

}

