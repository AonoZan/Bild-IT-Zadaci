
package zadaci_02_09_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Program creates list of few objects and prints them
	 * and calls method if implemented in color-able interface.
	 */
	public static void main(String[] args) {
		// create list for objects
		ArrayList<GeometricObject> list = new ArrayList<>();
		// add few objects to the list
		list.add(new Circle());
		list.add(new Square());
		list.add(new Rectangle());
		list.add(new Triangle());
		list.add(new Cube());
		// loop over list
		for (GeometricObject gObject : list) {
			// print to string and howToColor() if implemented
			System.out.println("Geometric object: " + gObject);
			if (gObject instanceof Colorable) {
				System.out.print("\t");
				((Colorable) gObject).howToColor();
			}
		}
	}

}
// color-able interface
interface Colorable {
	void howToColor();
}
// geometricObject class
class GeometricObject {
	@Override
	public String toString() {
		return "Simple geometric object.";
	}
}
// simple circle
class Circle extends GeometricObject {
	@Override
	public String toString() {
		return "Circle shape..";
	}
}
// square class that implements color-able interface
class Square extends GeometricObject implements Colorable {
	@Override
	public String toString() {
		return "This one is square.";
	}
	@Override
	public void howToColor() {
		System.out.println("Pixel * Width * Height .");
	}
}
// rectangle...
class Rectangle extends GeometricObject {
	@Override
	public String toString() {
		return "Rectangle of some sort.";
	}
}
// and triangle...
class Triangle extends GeometricObject {
	@Override
	public String toString() {
		return "Triangle.";
	}
}
// cube also implements color-able
class Cube extends GeometricObject implements Colorable {
	@Override
	public String toString() {
		return "Cubic object.";
	}
	@Override
	public void howToColor() {
		System.out.println("All four sides.");
	}
	
}