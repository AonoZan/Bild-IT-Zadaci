
package zadaci_22_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 �
 */
public class Zadatak_02 {
	/**
	 * Method creates three polygons and prints their perimeter and area.
	 * @param args
	 */
	public static void main(String[] args) {
		// create three polygons
		RegularPolygon poly1 = new RegularPolygon();
		RegularPolygon poly2 = new RegularPolygon(4, 4);
		RegularPolygon poly3 = new RegularPolygon(10, 4, 5.6, 7.8);
		// print status
		System.out.printf
				( "Polygon 1"
				+ "\n\tPerimeter: %.2f"
				+ "\n\tArea: %.2f\n"
				, poly1.getPerimeter()
				, poly1.getArea()
				);
		System.out.printf
				( "Polygon 2"
				+ "\n\tPerimeter: %.2f"
				+ "\n\tArea: %.2f\n"
				, poly2.getPerimeter()
				, poly2.getArea()
				);
		System.out.printf
				( "Polygon 3"
				+ "\n\tPerimeter: %.2f"
				+ "\n\tArea: %.2f\n"
				, poly3.getPerimeter()
				, poly3.getArea()
				);
	}
}
/**
 * Simple polygon class that has getters, setters
 * and methods for parameter and area.
 * @author AonoZan
 *
 */
class RegularPolygon {
	// default values
	private int n = 3;
	private double side = 1;
	private double x = 0, y = 0;
	// no-arg constructor
	public RegularPolygon() {
	}
	// that takes number of sides and length
	public RegularPolygon(int n, double side) {
		this(n, side, 0, 0);
	}
	// constructor that takes sides, size and location of the polygon
	public RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	// perimeter and area methods
	public double getPerimeter() {
		return this.n * this.side;
	}
	public double getArea() {
		return (this.n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / this.n));
	}
}
