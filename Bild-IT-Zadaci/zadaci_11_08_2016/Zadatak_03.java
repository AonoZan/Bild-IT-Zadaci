/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_11_08_2016;

import java.util.Date;

public class Zadatak_03 {
	/**
	 * Program prints current time and date using method currentTimeMillis().
	 * @param args
	 */
	public static void main(String[] args) {
		// create date object and print current date and time
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date.toString());
	}
}
