/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_03 {
	/**
	 * Method takes three numbers and prints them to console sorted
	 */
	public static void displaySortedNumbers(double num1, double num2, double num3) throws Exception {
		// create list from parameters, sort them and print separated with space
		double[] list = new double[]{num1, num2, num3};
		list = zadaci_03_08_2016.Zadatak_05.sort(list);
		System.out.printf("%.2f, %.2f, %.2f.\n", list[0], list[1], list[2]);
		
	}
	/**
	 * Method that creates three variables and prints them to console in unsorted order and sorted order.
	 */
	public static void main(String[] args) throws Exception {
		// create few wariables print them and then print them in sorted order
		double num1 = 3, num2 = -5, num3 = 5;
		System.out.printf("Unsorted decimals: %.2f, %.2f, %.2f.\n", num1, num2, num3);
		System.out.print("Sorted decimals: "); displaySortedNumbers(num1, num2, num3);
	}
}
