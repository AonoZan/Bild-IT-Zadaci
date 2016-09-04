
package zadaci_03_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	// print object
	public static void print(Object o) {
		System.out.println(o);
	}
	/** Program checks few rectangles if they are equal. */
	public static void main(String[] args) {
		// create few objects from Object and RectangleComparable class
		Object o = new Object(); print(o);
		RectangleCompareble r1 = new RectangleCompareble(2, 8); print(r1);
		RectangleCompareble r2 = new RectangleCompareble(3, 14); print(r2);
		RectangleCompareble r3 = new RectangleCompareble(8, 2); print(r3);
		// print output of equals method
		System.out.printf("Object o equals to Rectangle r1 (%b)"
				+ "\nRectangle r1 equals to Rectangle r2 (%b)"
				+ "\nRectangle r1 equals to Rectangle r3 (%b)"
				, o.equals(r1)
				, r1.equals(r2)
				, r1.equals(r3)
				);
		
	}
}
/** Simple RectangleComparable class */
class RectangleCompareble extends Rectangle implements Comparable<Rectangle> {
	// constructors mirror super constructors
	RectangleCompareble() {
		super();
	}
	RectangleCompareble(double width, double height) {
		super(width, height);
	}
	// rectangles are equal if their area is the same
	@Override
	public boolean equals(Object o) {
		return (this.getArea() == ((Rectangle)o).getArea());
	}
	// rectangles are compared based on their area
	@Override
	public int compareTo(Rectangle arg0) {
		if (this.getArea() > arg0.getArea()) {
			return 1;
		} else if (this.getArea() < arg0.getArea()) {
			return -1;
		}
		return 0;
	}
	
}
/** Rectangle class with area and perimeter methods. */
class Rectangle {
	// variables for width and height of rectangle
	private double width;
	private double height;
	// default constructor and one that takes width and height
	Rectangle() {
	}
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	// accessors and mutators
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getArea() {
		return this.width * this.height;
	}
	// retrieve perimeter
	public double getPerimeter() {
		return 2 *(this.width + this.height);
	}
	// to string method
	public String toString() {
		return "Rectangle of:\n\twidth:" +
				this.width + 
				"\n\theight: " +
				this.height +
				"\n\tarea: " +
				getArea() +
				"\n\tperimeter: " +
				getPerimeter();
	}
}