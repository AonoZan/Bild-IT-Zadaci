
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
				System.out.print("\tHow to color? ");
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
class GeometricObject implements Comparable<GeometricObject> {
	private int size;
	
	public GeometricObject() {
		this(1);
	}
	public GeometricObject(int size) {
		this.size = size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return this.size;
	}
	public double getArea(){
		return 0;
	}
	@Override
	public String toString() {
		return "Simple geometric object.";
	}
	// https://github.com/LuizGsa21/intro-to-java-10th-edition/blob/master/src/ToolKit/GeometricObject.java
	public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        return (o1.compareTo(o2) >= 0) ? o1 : o2;
    }
	@Override
    public int compareTo(GeometricObject object) {
        if (this.size > object.getSize())
            return 1;
        else if (this.size < object.getSize())
            return -1;
        else
            return 0;
    }
}
// simple circle
class Circle extends GeometricObject {
	private double radius;
	Circle(){
		this(1);
	}
	Circle(double newRadius){
		radius = newRadius;
	}
	@Override
	public double getArea(){
		return radius * radius * Math.PI;
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double newRadius){
		if(newRadius >= 0){
			radius = newRadius;
		}
	}
	@Override
	public String toString() {
		return "Circle shape..";
	}
}
// square class that implements color-able interface
class Square extends GeometricObject implements Colorable {
	public Square() {
		super();
	}
	public Square(int size) {
		super(size);
	}
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
	public Rectangle() {
		super();
	}
	public Rectangle(int size) {
		super(size);
	}
	@Override
	public String toString() {
		return "Rectangle of some sort.";
	}
}
// and triangle...
class Triangle extends GeometricObject {
	public Triangle() {
		super();
	}
	public Triangle(int size) {
		super(size);
	}
	@Override
	public String toString() {
		return "Triangle.";
	}
}
// cube also implements color-able
class Cube extends GeometricObject implements Colorable {
	public Cube() {
		super();
	}
	public Cube(int size) {
		super(size);
	}
	@Override
	public String toString() {
		return "Cubic object.";
	}
	@Override
	public void howToColor() {
		System.out.println("All four sides.");
	}
	
}