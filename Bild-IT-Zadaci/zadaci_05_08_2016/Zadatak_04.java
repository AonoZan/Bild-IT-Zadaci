/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_04 {
	/**
	 * Method for reversing values of some array.
	 * @param list of any size with integers 
	 * @return
	 * @throws Exception
	 */
	public static int[] reverse(int[] list) throws Exception {
		// if list is null return null
		if (list == null) {
			System.out.println("Cant reverse list(null as argument)");
			return null;
		} else if (list.length == 1) return list;
		// loop to half of the length of the list and swap values
		for (int i = 0; i < list.length/2; i++) {
			list[i] += list[list.length - i - 1];
			list[list.length - i - 1] = list[i] - list[list.length - i - 1];
			list[i] -= list[list.length - i - 1];
		}
		return list;
	}
	/**
	 * Method asks user to enter 10 values and stores them in list.
	 * List is then reversed and printed to the console.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables and prompt user to enter 10 numbers
		// loop until user enters all 10 of them
		int[] userNumbers = new int[10];
		int userNumber = 0;
		System.out.println("Enter 10 numbers: ");
		for (int i = 0; i < userNumbers.length; i++) {
			while (true) {
				try {
					// try to get number from user
					System.out.printf("Enter %d value: ", (i + 1));
					userNumber = zadaci_01_08_2016.Zadatak_05.readFromConsole(userNumber);
					// fill correct value in list if it's not default one
					if (userNumber != 0) userNumbers[i] = userNumber;
					// at the end print list in original and reversed
					if (i == userNumbers.length - 1) {
						System.out.println("You entered list:");
						zadaci_01_08_2016.Zadatak_04.printList(userNumbers);
						System.out.println("Reversed list:");
						userNumbers = reverse(userNumbers);
						zadaci_01_08_2016.Zadatak_04.printList(userNumbers);
					}
					break;
				// if user enters string or character print message and reset counter
				} catch (Exception e) {
					System.out.println(e.getMessage() + " Try again.");
					i--;
					break;
				} 
			} 
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
