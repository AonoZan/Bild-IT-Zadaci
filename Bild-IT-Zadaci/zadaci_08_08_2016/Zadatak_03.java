/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_08_08_2016;

public class Zadatak_03 {
	/**
	 * Method returns index of first matching value in list.
	 * @param list
	 * @param value
	 * @return index of value in list,<br> -1 if list is null or<br>-2 if no such value in list
	 */
	public static int getIndexOf(String[] list, String value) {
		// if list is empty return -1
		if (list == null) return -1;
		// go trough whole list and if any value matches argument return that index
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(value)) return i;
		}
		// return -2 for no value found
		return -2;
	}
	/**
	 * Program asks for name of the month(first three letters) and year.
	 * Program then prints total number of days in that month.
	 * @param args
	 */
	public static void main(String[] args) {
		// create list of all months
		String[] monthNames = new String[]{
				"Jan",
				"Feb",
				"Mar",
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Avg",
				"Sep",
				"Oct",
				"Nov",
				"Dec"
		};
		// create variable for month and year and ask user for values
		int year = 0;
		String month = "";
		System.out.println("Enter values for date.");
		while (true) {
			try {
				// if value for month is still on default ask for another one
				if (month == "") {
					System.out.print("Enter month(first three letters): ");
					month = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
					// if user enters wrong value for month reset it and ask again
					if (getIndexOf(monthNames, month) == -2) {
						System.out.printf("%s is incorrect value for month.", month);
						month = "";
						throw new Exception("Try again..");
					}
				}
				// if value for month is still on default ask for another one
				if (year == 0) {
					System.out.print("Enter year: ");
					year = zadaci_01_08_2016.Zadatak_05.readFromConsole(year);
					// if user enters zero or negative year reset it and ask again
					if (year < 1) {
						System.out.printf("%d is incorrect value for year.", year);
						year = 0;
						throw new Exception("Try again..");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// print message and close scanner
		System.out.printf("%s of %d had %d days.\n",
				month,
				year,
				zadaci_08_08_2016.Zadatak_02.getMaxDay(year, getIndexOf(monthNames, month) + 1));
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
