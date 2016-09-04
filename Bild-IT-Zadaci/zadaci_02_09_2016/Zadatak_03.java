
package zadaci_02_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {

	public static void main(String[] args) {
		// create two objects
		ComparableCircle c1 = new ComparableCircle(10);
		ComparableCircle c2 = new ComparableCircle(10.1);
		// compare to get max and print statistic
		ComparableCircle cMax = (ComparableCircle)GeometricObject.max(c1, c2);
		System.out.printf("Circle with area %.2f is max when compared two circles:"
				+ "\nCircle1: area = %.2f"
				+ "\nCircle2: area = %.2f"
				, cMax.getArea()
				, c1.getArea()
				, c2.getArea());
	}

}
class ComparableCircle extends Circle implements Comparable<GeometricObject>{
	ComparableCircle(){
		super(1);
	}
	ComparableCircle(double newRadius){
		super(newRadius);
	}
	// https://github.com/LuizGsa21/intro-to-java-10th-edition/blob/master/src/ToolKit/GeometricObject.java
	public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return (o1.compareTo(o2) >= 0) ? o1 : o2;
    }
	// compare two circles area and return result as int 1 0 or -1
	@Override
    public int compareTo(GeometricObject object) {
        if (getArea() > object.getArea())
            return 1;
        else if (getArea() < object.getArea())
            return -1;
        else
            return 0;
    }
}
