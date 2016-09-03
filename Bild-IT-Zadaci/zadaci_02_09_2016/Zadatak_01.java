
package zadaci_02_09_2016;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Calendar;

import projekat_sedmica_01.Month;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Program takes date (year month) from arguments and displays calendar for that month. */
	public static void main(String[] args) {
		// create variables and try to process values from arguments
		int year = 0, month = 0;
		if (args.length > 0) {// there should be two arguments
			if (args.length > 1) { // if more than two arguments
				try {
					year = Integer.parseInt(args[0]);	// process year as integer
					month = Integer.parseInt(args[1]);	// process month
				} catch (Exception e) {
					// wrong arguments exit
					System.out.println("Error in parsing arguments. (year month)");
					System.exit(0);
				}
			} else { // if only one argument
				// create loval time
				LocalDateTime timePoint = LocalDateTime.now();
				try {
					// try to parse argument
					int argument = Integer.parseInt(args[0]);
					// if argument is potential month set it so
					if (argument >= 1 && argument <= 12) {
						month = argument;
						year = timePoint.getYear();
					} else { // else set it to year
						month = timePoint.getMonthValue();
						year = argument;
					}
				} catch (Exception e) {
					// argument couldn't be parsed, exit
					System.out.println("Error when parsing argument.");
					System.exit(0);
				}
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

