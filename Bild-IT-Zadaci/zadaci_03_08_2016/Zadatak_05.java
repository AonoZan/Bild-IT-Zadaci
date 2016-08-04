/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

public class Zadatak_05 {
	/**
	 * Method for sorting list of integers. 
	 * @param list that needs to be sorted
	 * @return New sorted list
	 * @throws Exception If list is null.
	 */
	public static double[] sort(double[] list) throws Exception{
		// if list is null throw an exception with message
		if (list == null) {
			throw new Exception("Can't sort list. List has no value(null).");
		}
		// loop from first element to next-to last one
		for (int i = 0; i < list.length-1; i++) {
			// set boolean value so that we can exit when we are sure we finished
			boolean finished = true;
			// loop from first one to last one sorted
			for (int j = 0; j < list.length-i-1; j++) {
				// if current element is bigger than next one switch them and
				// set boolean that we are still not sure if we sorted everything
				if (list[j] > list[j+1]) {
					double tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
					finished = false;
				}
			}
			// if finished early break
			if(finished) break;
		}
		return list;
	}
	/**
	 * Method for sorting rows in array from lowest to highest in row.
	 * @param array argument that can be of any size(ragged)
	 * @return list that is sorted or null if argument that is passed is null
	 */
	public static double[][] sortRows(double[][] array) {
		// if argument is null value return null
		if (array == null) {
			System.out.println("Can't sort rows of 2D array.(null argument)");
			return null;
		}
		// loop for every row and try to sort it
		for (double[] row : array) {
			try {
				row = sort(row);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return array;
	}
	/**
	 * Method for printiing 2D list. Every item in list is printed and separated with space.
	 * At the end of the each row new line is entered.
	 * @param list that can be of any size(ragged). If it's null method exits with message.
	 */
	public static void printList(double[][] list) {
		// if list is null return immediately or if list contain only one item print it and exit
		if (list == null) {
			System.out.println("Cant print list that has null as value.");
			return;
		} else if (list.length == 1 && list[0].length == 1) {
			System.out.print(list[0][0] + " ");
			return;
		}
		// loop for every row and if contains items print it using printList() method
		for (double[] ds : list) {
			if (ds == null) continue;
			else Zadatak_02.printList(ds);
			System.out.println();
		}
	}
	/**
	 * Main method that asks user value for NxN matrix.
	 * method asks for correct value until user enters one.
	 * Matrix is created and correct values are filled with user input.
	 * Then rows of the matrix are sorted and whole matrix is printed.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables for storing size of the array
		int size = 0;
		// loop untill both variables gets right values
		while (true) {
			try {
				// if row value is wrong try to get correct one
				if (size <= 0) {
					System.out.print("Enter value for NxN matrix: ");
					size = zadaci_01_08_2016.Zadatak_05.readFromConsole(size);
					// if user enters integer but for example negative reset value and throw exception
					if (size < 1) {
						size = 0;
						throw new Exception("Wrong value for rows.");
					}
				}
				// if value is correct break
				break;
			// when some exception happens print message and ask user to enter correctt value again
			} catch (Exception e) {
				System.out.println(e.getMessage() + "Try again.");
			}
		}
		// create new NxN matrix
		double[][] array = new double[size][size];
		// fill matrix with values sort it and print to the console
		array = Zadatak_04.fillListFromConsoleInput(array);
		sortRows(array);
		System.out.println("Printing sorted matrix:");
		printList(array);
	}
}
