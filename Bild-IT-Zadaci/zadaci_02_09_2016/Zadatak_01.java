
package zadaci_02_09_2016;

import projekat_sedmica_01.Month;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Program takes date (year month) from arguments and displays calendar for that month. */
	public static void main(String[] args) {
		// create variables and try to process values from arguments
		int year = 0, month = 0;
		if (args.length == 2) {// there should be two arguments
			try {
				year = Integer.parseInt(args[0]);	// process year as integer
				month = Integer.parseInt(args[1]);	// process month
			} catch (Exception e) {
				// wrong arguments exit
				System.out.println("Error in parsing arguments. (year month)");
				System.exit(0);
			}
		} else {
			// wrong number of arguments exit
			System.out.println("Please provide two argument. (year month)");
			System.exit(0);
		}
		// create calendar and print it
		Month monthPicture = new Month(year, month);
		System.out.printf("\n%25s %d\n", Month.getMonthName(month), year);
		System.out.println("------------------------------------------");
		System.out.println(monthPicture.getDisplayString());
	}
}

