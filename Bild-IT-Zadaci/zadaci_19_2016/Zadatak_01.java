
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Method for sorting employes working hours.
	 * List contains lists of employees and their working hours.
	 * Lists are sorted in decreasing order.
	 * @param list
	 * @return
	 */
	public static int[][] sortHours(int[][] list) {
		// go trough all data
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i -1; j++) {
				// if next data has lower value switch data
				if (list[j][1] < list[j + 1][1]) {
					// switch employee hours
					list[j][1] += list[j + 1][1];
					list[j + 1][1] = list[j][1] - list[j + 1][1];
					list[j][1] -= list[j + 1][1];
					// switch employes indexes
					list[j][0] += list[j + 1][0];
					list[j + 1][0] = list[j][0] - list[j + 1][0];
					list[j][0] -= list[j + 1][0];
				}
			}
		}
		return list;
	}
	/**
	 * Method returns sum of all elements in list.
	 * @param list
	 * @return
	 */
	public static int sum(int[] list) {
		// for null argument return 0
		if (list == null) return 0;
		// create variable to store sum and iterate over list
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
		// create couple of employees
		int[] emploayee0 = new int[] {2, 4, 3, 4, 5, 8, 8};
		int[] emploayee1 = new int[] {7, 3, 4, 3, 3, 4, 4};
		int[] emploayee2 = new int[] {3, 3, 4, 3, 3, 2, 2};
		int[] emploayee3 = new int[] {9, 3, 4, 7, 3, 4, 1};
		int[] emploayee4 = new int[] {3, 5, 4, 3, 6, 3, 8};
		int[] emploayee5 = new int[] {3, 4, 4, 6, 3, 4, 4};
		int[] emploayee6 = new int[] {3, 7, 4, 8, 3, 8, 4};
		int[] emploayee7 = new int[] {6, 3, 5, 9, 2, 7, 9};
		// add all employees to the list
		int[][] employeeHours = new int[][]{
			emploayee0,
			emploayee1,
			emploayee2,
			emploayee3,
			emploayee4,
			emploayee5,
			emploayee6,
			emploayee7
		};
		// create list to store sum of hours
		int[][] sumOfHours = new int[8][2];
		// fill list with sum of working hours
		for (int i = 0; i < sumOfHours.length; i++) {
			sumOfHours[i][0] = i;
			sumOfHours[i][1] = sum(employeeHours[i]);
		}
		// sort employes stats in decreasing order
		sumOfHours = sortHours(sumOfHours);
		// print stats
		for (int[] is : sumOfHours) {
			System.out.printf("Emloyee %d: %dh\n",
					is[0],
					is[1]);
		}
		
	}

}

