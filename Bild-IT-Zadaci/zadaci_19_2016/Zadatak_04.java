
package zadaci_19_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	// method for returning sum of all elements in list
	public static int sum(int[] m) {
		int sum = 0;
		for (int i : m) {
			sum += i;
		}
		return sum;
	}
	/**
	 * Method sorts list in two passes.
	 * First pass sorts rows and second columns.
	 * @param m
	 */
	public static void sort(int m[][]) {
		// sort rows
		for (int i = 0; i < m.length-1; i++) {
			for (int j = 0; j < m.length-i-1; j++) {
				// if row is greater than on in front switch
				if (sum(m[j]) > sum(m[j + 1])) {
					int[] tmp = m[j];
					m[j] = m[j + 1];
					m[j + 1] = tmp;
					
				}
			}
		}
		// sort columns
		for (int i = 0; i < m.length-1; i++) {
			for (int j = 0; j < m.length-i-1; j++) {
				// if column is greater than one in front switch
				if (m[j][0] > m[j + 1][0]) {
					int[] tmp = m[j];
					m[j] = m[j + 1];
					m[j + 1] = tmp;
					
				}
			}
		}
	}
	/**
	 * Program sorts list of integer type.
	 * @param args
	 */
	public static void main(String[] args) {
		// create list
		int[][] list = new int[][]{
			{4, 2},
			{1, 7},
			{4, 5},
			{1, 2},
			{1, 1},
			{4, 1}
		};
		// sort and print
		sort(list);
		Zadatak_03.printList(list);
	}

}

