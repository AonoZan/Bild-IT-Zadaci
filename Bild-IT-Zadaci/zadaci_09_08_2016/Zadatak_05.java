/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_05 {
	/**
	 * Method converts milliseconds into human readable time representation.
	 * <br>Example: 100000 millis >> 0:1:40
	 * @param millis
	 * @return
	 */
	public static String convertMillis(long millis) {
		// for negative values return blank time
		if (millis < 1) return "||:||:||";
		// calculate total seconds minutes and hours
		long seconds, minutes, hours;
		seconds = millis / 1000;
		minutes = seconds / 60;
		hours = minutes / 60;
		// return reminder of each separated by :
		return hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;
	}
	/**
	 * Simple program that tests convertMillis() method.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertMillis(100000));
	}
}
