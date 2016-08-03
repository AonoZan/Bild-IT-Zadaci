/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

import zadaci_01_08_2016.Zadatak_05;

public class Zadatak_04 {
	/**
	 * Method that locate largest element in array list. Method can handle ragged lists.
	 * If list contains empty rows they are skiped.
	 * @param a list that contains double values(can be ragged) 
	 * @return int list that contains position of the last largest element in list.
	 * First value is row and second column of the position.
	 * If empty list is passed as argument then null is returned.
	 */
	public static int[] locateLargest(double[][] a) {
		// in case that list is empty or null simply return null
		if (a == null || a.length < 1) {
			System.out.println("Empty list passed as argument(null is returned).");
			return null;
		}
		// create list to store position and value of the largest element in list
		int[] location = new int[2];
		double[] largest = null;
		for (int i = 0; i < a.length; i++) {
			// if current row is empty or null skip it
			if (a[i] == null || a[i].length < 1) continue;
			// loop for every item in list
			for (int j = 0; j < a[i].length; j++) {
				// if largest variable has no value(null) create value from first item in list
				if (largest == null) largest = new double[]{a[i][j]};
				// if largest is lower than current in list update it and location values
				if (largest[0] < a[i][j]) {
					largest[0] = a[i][j];
					location[0] = i;
					location[1] = j;
				}
			}
		}
		// list is returned
		return location;
	}
	/**
	 * Method to make easy entering lots of integer values from console.
	 * List will be updated and new values will be added to te list if they are decimal values.
	 * @param list to be filled with values
	 * @param fixedLength this is argument for java to distinguish between simmilar method that fills list of infinite size
	 * @return list that has user entered values
	 */
	public static double[][] fillListFromConsoleInput(double[][] list, boolean fixedLength) {
		// chack if passed list has value
		if (list == null) {
			System.out.println("Cant fill list that is null.(null is returned)");
			return null;
		}
		// set default values
		double inputDecimal = 1;
		// loop for every row
		for (int i = 0; i < list.length; i++) {
			// if some of the rows are wrong length or null skip current iteration
			if (list[i] == null || list[i].length < 1) {
				System.out.printf("Cant fill %d row.(empty or null)\n", i);
				continue;
			}
			// print info message and loop for every column
			System.out.printf("Enter %d decimal value%s for %d row:\n", list[i].length, list[i].length > 1 ? "'s" : "", (i + 1));
			for (int j = 0; j < list[i].length; j++) {
				// try to get right value from user
				while (true) {
					System.out.printf("Enter %d value: ", (j +1));
					try {
						// read input and fill in list
						inputDecimal = Zadatak_02.readFromConsole(inputDecimal);
						list[i][j] = inputDecimal;
						break;
						// if error occurs print message
					} catch (Exception e) {
						System.out.println(e.getMessage() + " Try again.");
					} 
				}
			} 
		}
		// return cleaned list from zeroes(empty values)
		return list;
	}
	/**
	 * Main method that asks user to enter values for rows and columns of the new 2D list.
	 * Input is asked until correct value is entered.
	 * Then using method fillFromConsoleInput() array is filled with values.
	 * At the end largest element in the list is printed and its position that is returned from locateLargest(). 
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables for storing number of columns and rows and ask user to enter values
		int row = 0, col = 0;
		System.out.println("Enter value for how many rows and columns will be in list.");
		// loop untill both variables gets right values
		while (true) {
			try {
				// if row value is wrong try to get correct one
				if (row <= 0) {
					System.out.print("Enter value for rows: ");
					row = Zadatak_05.readFromConsole(row);
					// if user enters integer but for example negative reset value and throw exception
					if (row < 1) {
						row = 0;
						throw new Exception("Wrong value for rows.");
					}
				}
				// if column value is wrong try to get correct one
				if (col <= 0) {
					System.out.print("Enter value for columns: ");
					col = Zadatak_05.readFromConsole(col);
					// if user enters integer but for example negative reset value and throw exception
					if (col < 1) {
						col = 0;
						throw new Exception("Wrong value for rows.");
					}
				}
				// if both values are correct break
				break;
			// when some exception happens print message and ask user to enter correctt value again
			} catch (Exception e) {
				System.out.println(e.getMessage() + "Try again.");
			}
		}
		// create new 2D array and fill it with values
		double[][] array = new double[row][col];
		array = fillListFromConsoleInput(array, true);
		// get position of the largest element in array and print it
		int[] position = locateLargest(array);
		System.out.printf("Largest value in the list is: %.2f[%d, %d].",
				array[position[0]][position[1]], position[0], position[1]);
	}
}
