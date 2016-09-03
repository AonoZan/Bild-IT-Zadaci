
package zadaci_02_09_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Program creates few objects and compare them to get max. */
	public static void main(String[] args) {
		// create two objects
		Circle c1 = new Circle(11);
		Circle c2 = new Circle(20);
		// compare to get max and print statistic
		Circle cMax = (Circle)GeometricObject.max(c1, c2);
		System.out.printf("Of circle1(%d) and circle(%d) max is circle(%d)\n"
				, c1.getSize()
				, c2.getSize()
				, cMax.getSize());
		
		// create two rectangles
		Rectangle r1 = new Rectangle(45);
		Rectangle r2 = new Rectangle(31);
		// compare to get max and print it
		Rectangle rMax = (Rectangle)GeometricObject.max(r1, r2);
		System.out.printf("Of rectangle1(%d) and rectangle(%d) max is rectangle(%d)\n"
				, r1.getSize()
				, r2.getSize()
				, rMax.getSize());
		
	}

}

