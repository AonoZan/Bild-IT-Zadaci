
package zadaci_17_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Method formats number with width variable placing leading numbers as 0.
	 * 
	 * @param number
	 * @param width
	 * @return
	 */
	public static String format(int number, int width)  {
		// return formated string
		return String.format("%0" + width + "d", number);
	}
	/**
	 * Program tests method format()
	 */
	public static void main(String[] args) {
		System.out.println(format(34, 8));
	}

}

