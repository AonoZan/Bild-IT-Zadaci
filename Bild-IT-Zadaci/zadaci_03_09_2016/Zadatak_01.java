
package zadaci_03_09_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Program creates few objects and checks if they are equal. */
	public static void main(String[] args) {
		// create object and three circles
		Object o = new Object();
		CircleComparable c1 = new CircleComparable(14);
		CircleComparable c2 = new CircleComparable(2);
		CircleComparable c3 = new CircleComparable(14);
		// print output of equals method
		System.out.printf("Object o equals to Circle c1 (%b)"
				+ "\nCircle c1 eqials to Circle c2 (%b)"
				+ "\nCircle c1 eqials to Circle c3 (%b)"
				, o.equals(c1)
				, c1.equals(c2)
				, c1.equals(c3)
				);
	}

}
/** Simple circle class that implements comparable and overrides objects equals() method. */
class CircleComparable extends Circle implements Comparable<Circle> {
	// constructors call super constructor
	public CircleComparable() {
		super();
	}
	public CircleComparable(int radius) {
		super(radius);
	}
	// override equals, circles are equal if they have same value radius
	@Override
	public boolean equals(Object o){
		return (((Circle)o).getRadius() == getRadius());
	}
	// override compare to, circles are compared based on their radius
	@Override
	public int compareTo(Circle arg0) {
		if (getRadius() > arg0.getRadius()) {
			return 1;
		} else if (getRadius() < arg0.getRadius()) {
			return -1;
		}
		return 0;
	}
}
/** Simple circle class. */
class Circle {
	private int radius;
	// default and constructor that takes radius as argument
	public Circle() {
		this(1);
	}
	public Circle(int radius) {
		this.radius = radius;
	}
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
}