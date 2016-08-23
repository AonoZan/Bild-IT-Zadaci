
package zadaci_22_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Program asks fom user values for linear equation
	 * and prints result if it's solvable.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list of names for convenience and list for values
		String[] nameList = new String[] {"a", "b", "c", "d", "e", "f"};
		double[] eqL = new double[6];
		// prompt user to enter values
		System.out.println("Enter values for the eauation.");
		while (true) {
			// loop until all values are taken
			for (int i = 0; i < nameList.length; i++) {
				try {
					// ask for value in current iteration
					System.out.print("Enter value for " + nameList[i] + ": ");
					eqL[i] = input.nextDouble();
				} catch (InputMismatchException ex) {
					// for wrong input clear input and loop back 
					System.out.println("Please enter decimal number.");
					i--;
					input.nextLine();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.exit(0);
				}
			}
			break;
		}
		// create new equation
		LinearEquation equation = new LinearEquation
				(eqL[0], eqL[1], eqL[2], eqL[3], eqL[4], eqL[5]);
		// print result if it's solvable
		if (equation.isSolvable()) {
			System.out.println("X = " + equation.getX());
			System.out.println("Y = " + equation.getY());
		} else {
			System.out.println("Equation has no solution.");
		}
		input.close();
	}

}
/**
 * Linear equation class.
 * Use to solve linear equation.
 * @author AonoZan
 *
 */
class LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	public LinearEquation(double a, double b, double c, double d, double e, double f) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
	public double getF() {
		return f;
	}
	/**
	 * Method for checking if equation is solvable.
	 * @return true if ist's solvable, else false
	 */
	public boolean isSolvable() {
		return (a * d - b * c) != 0 ? true : false;
	}
	// methods for X and Y from equation
	public double getX() {
		return (e * d - b * f) / (a * d - b * c);
	}
	public double getY() {
		return (a * f - e * c) / (a * d - b * c);
	}
}
