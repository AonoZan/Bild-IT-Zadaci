
package zadaci_26_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**Program creates triangle from user input*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list of sides color and filled variables
		double[] sides = new double[3];
		String color = null, filled = null;
		// rompt user for values
		System.out.println("Enter triangle sides, color and fill.");
		while (true) {
			// get side values until all correctly added
			for (int i = 0; i < sides.length; i++) {
				try {
					System.out.print("Enter side" + i+1 + ": ");
					sides[i] = input.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Please enter decimal number.");
					input.nextLine();
					i--;
				}
			}
			// clear console from input
			input.nextLine();
			// get color and filled values until filled is correct
			while (filled == null) {
				// if color is not set get one
				if (color == null) {
					System.out.print("What's the color of the triangle: ");
					color = input.nextLine();
				}
				// if filled is not set get one
				if (filled == null) {
					System.out.print("Is triangle filled(true, false): ");
					filled = input.nextLine();
					// if valid color continue else reset
					if (filled.compareTo("true") == 0 || filled.compareTo("true") == 0) {
						continue;
					} else {
						filled = null;
					}
				}
			}
			// all values set break
			break;
		}
		// create new triangle with user sides
		Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
		// set color and filled values
		triangle.setColor(color);
		triangle.setFilled(filled.compareTo("true") == 0 ? true : false);
		// print toString() metohod
		System.out.println("Triangle:\n" + triangle.toString());
		
		input.close();
	}

}

/**
 * Simple triangle class with accessors and mutators
 * along with get area/perimeter methods.
 * @author AonoZan
 *
 */
class Triangle extends GeometricObject {
	private double side1, side2, side3;
	
	Triangle() {
		this(1, 1, 1);
	}

	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}
	/**Method returns this triangle perimeter.*/
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	/**Method returns this triangle area.*/
	public double getArea() {
		double s = getPerimeter()/2;
		return Math.sqrt(s * (s - side1)*(s - side2)*(s - side3));
	}
	@Override
	public String toString() {
		return String.format
				( "%s"
				+ "\tside1: %.2f\n"
				+ "\tside2: %.2f\n"
				+ "\tside3: %.2f\n"
				, super.toString()
				, this.side1
				, this.side2
				, this.side3
				);
	}
}

/**
 * Simple geometric object class with basic attributes.
 * 
 * @author AonoZan
 *
 */
class GeometricObject {
	private String color;
	private boolean filled = false;
	private java.util.Date dateCreated;
	
	public GeometricObject() {
		this("white");
	}
	public GeometricObject(String color) {
		dateCreated = new java.util.Date();
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public java.util.Date getDateCreated() {
		return this.dateCreated;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public boolean isFilled() {
		return filled;
	}
	@Override
	public String toString() {
		return String.format
				( "\tcolor: %s\n"
				+ "\tdate: %s\n"
				+ "\tfilled: %b\n"
				, this.getColor()
				, getDateCreated()
				, this.filled
				);
	}
}