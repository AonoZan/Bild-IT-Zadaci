
package zadaci_26_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] sides = new double[3];
		String color = null;
		String filled = null;
		System.out.println("Enter triangle sides, color and fill.");
		while (true) {
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
			input.nextLine();
			while (filled == null) {
				if (color == null) {
					System.out.print("What's the color of the triangle: ");
					color = input.nextLine();
				}
				if (filled == null) {
					System.out.print("Is triangle filled(true, false): ");
					filled = input.nextLine();
					if (filled.compareTo("true") == 0 || filled.compareTo("true") == 0) {
						continue;
					} else {
						filled = null;
					}
				}
			}
			break;
		}
		
		
		
		Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
		triangle.setColor(color);
		triangle.setFilled(filled.compareTo("true") == 0 ? true : false);
		System.out.println("Triangle:\n" + triangle.toString());
		
		input.close();
	}

}
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
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public double getArea() {
		double s = getPerimeter()/2;
		return Math.sqrt(s * (s - side1)*(s - side2)*(s - side3));
	}
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