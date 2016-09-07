
package zadaci_06_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Method calculates series ni = 1 + 1/i2 + n/i3... */
	public static double sumSeries(int index) {
		// if index is 1 return index
		// else return sum series with lower index plus 1/index
		if (index == 1) {
			return 1;
		} else {
			return sumSeries(index - 1) + (1.0 / index);  
		}
	}
	/** Program calculates series for index 10. */
	public static void main(String[] args) {
		// print series of number 10
		System.out.println("Series of number for index 10 is " + sumSeries(10));
	}
}

