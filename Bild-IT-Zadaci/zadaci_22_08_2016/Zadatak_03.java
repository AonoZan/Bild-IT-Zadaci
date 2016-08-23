
package zadaci_22_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create values for equation and prompt user for values
		System.out.println("Enter values for a, b and c.");
		double a = 0, b = 0, c = 0;
		while (true) {
			try {
				// get a value, can't be 0
				do {
					System.out.print("Enter value for a(no 0): ");
					a = input.nextDouble();
				} while (a == 0);
				// get b and c property
				System.out.print("Enter value for b: ");
				b = input.nextDouble();
				System.out.print("Enter value for c: ");
				c = input.nextDouble();
				// break when all values taken
				break;
			// for wrong input clear console
			} catch (InputMismatchException e) {
				System.out.println("Please enter decimal number.");
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Error in input.");
				System.exit(0);
			}
		}
		// create new object from class and get discriminant
		QuadraticEquation equation = new QuadraticEquation(a, b, c);
		double discriminant = equation.getDescriminant();
		// for solvable equation print both rots
		if (discriminant > 0) {
			System.out.printf
					( "Roots: \n%.2f\n%.2f\n"
					,equation.getRoot1()
					,equation.getRoot2()
							);
		// for equation with 0 as discriminant print one root
		} else if (discriminant == 0) {
			System.out.printf
			( "Only one root: %.2f\n"
			,equation.getRoot1()
					);
		// equation which has no real root print message only
		} else {
			System.out.println("Equation has no real roots.");
		}
		input.close();
	}
}
/**
 * Quadratic equation class.
 * Contains methods for discriminant and two roots.
 * @author AonoZan
 *
 */
class QuadraticEquation {
	// values for the equation
	private double a;
	private double b;
	private double c;
	// constructor that sets all three values
	public QuadraticEquation(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
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
	// return discriminant
	public double getDescriminant() {
		return (b * b) - (4 * a * c);
	}
	// methods for two roots
	public double getRoot1() {
		double descriminant = getDescriminant();
		if (descriminant > 0) {
			return (-b + Math.sqrt(getDescriminant())) / (a + a);
		} else {
			return 0;
		}
	}
	public double getRoot2() {
		double descriminant = getDescriminant();
		if (descriminant > 0) {
			return (-b - Math.sqrt(getDescriminant())) / (a + a);
		} else {
			return 0;
		}
	}
}
