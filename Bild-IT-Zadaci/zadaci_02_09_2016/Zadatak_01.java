
package zadaci_02_09_2016;

import projekat_sedmica_01.Month;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	public static void main(String[] args) {
		int year = 0, month = 0;
		if (args.length == 2) {
			try {
				year = Integer.parseInt(args[0]);
				month = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.out.println("Error in parsing arguments. (year month)");
				System.exit(0);
			}
		} else {
			System.out.println("Please provide two argument. (year month)");
			System.exit(0);
		}
		Month monthPicture = new Month(year, month);
		System.out.println(monthPicture.getDisplayString());
	}
}

