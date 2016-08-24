
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Program creates two points,
	 * measures and prints distance between two.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyPoint point1 = new MyPoint();
		MyPoint point2 = new MyPoint(10, 30.5);
		
		System.out.printf("Distance between (%.2f, %.2f)"
				+ "\nand (%.2f, %.2f) is: %.2f\n"
				, point1.getX()
				, point1.getY()
				, point2.getX()
				, point2.getY()
				, point1.distance(point2));
		
	}

}
/**
 * Simple MyPoint class that have distance method.
 * Use to store point location on a 2D plane and retrieve distance
 * to other points. 
 * 
 * @author AonoZan
 *
 */
class MyPoint {
	// variable to store point location
	private double x, y;
	
	public MyPoint() {
		this(0, 0);
	}
	public MyPoint(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	/**
	 * Method retrieve distance to coordinates from arguments.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double distance(double x, double y) {
		return Math.sqrt(Math.pow((x-this.x), 2) + Math.pow((y-this.y), 2));
	}
	/**
	 * Method retrieve distance to point in argument.
	 * 
	 * @param point
	 * @return
	 */
	public double distance(MyPoint point) {
		return distance(point.getX(), point.getY());
	}
}
