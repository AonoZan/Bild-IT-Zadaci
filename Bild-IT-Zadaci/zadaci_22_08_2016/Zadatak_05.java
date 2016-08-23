
package zadaci_22_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Program asks for 4 points on 2D plane.
	 * Four points represent two lines and
	 * program prints result if those two lines intersect.
	 * @see <a href="http://www.mathopenref.com/coordintersection.html">Test intersecting points</a>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list of locations for points and prompt user for values
		double[] loc = new double[8];
		while (true) {
			// loop until list is filled
			for (int i = 0; i < loc.length; i++) {
				try {
					// ask for location of points and sweep from console
					System.out.printf("Enter point%d %s: ",
							i / 2,
							i % 2 == 0 ? "X" : "Y");
					loc[i] = input.nextDouble();
				} catch (InputMismatchException e) {
					// if wrong input print message, clear console and loop back
					System.out.println("Please enter decimal.");
					input.nextLine();
					i--;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
			}
			break;
		}
		// translate into points for clearer calculations
		double x1 = loc[0];
		double y1 = loc[1];
		double x2 = loc[2];
		double y2 = loc[3];
		double x3 = loc[4];
		double y3 = loc[5];
		double x4 = loc[6];
		double y4 = loc[7];
		
		/* other primer using Linear equation
		double a = y1 - y2;
		double b = x2 - x1;
		double c = y3 - y4;
		double d = x4 - x3;
		double e = (y1 - y2) * x1 - ((x1 - x2) * y1);
		double f = (y3 - y4) * x3 - ((x3 - x4) * y3);
		
		double x = (e * d - b * f) / (a * d - b * c);
		double y = (a * f - e * c) / (a * d - b * c);
		 */
		
		double x, y;
		// calculate divider
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		// if divider is 0 lines are parallel
		if (d == 0)
			System.out.println("Lines are parallel.");
		// calculate and print intersecting point
		else{
			x = ((x1*y2-y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4))/d;
			y = ((x1*y2-y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4))/d;
			System.out.printf("The intersecting point is at (%.4f, %.4f)\n", x, y);
		}
		
		input.close();
	}

}

