
package zadaci_03_09_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Program tests Octagon class and it's cloneable and comparable methods. */
	public static void main(String[] args){
		// create octagon and print it
		Octagon oct = new Octagon(5);
		System.out.println("Octagon:\n" + oct);
		// clone octagon and print clone
		Octagon clone = (Octagon)oct.clone();
		System.out.println("Clone:\n" + clone);
		// test if octagon and clone are equal
		System.out.printf("Octagon and clone compareTo = %d\n"
				, oct.compareTo(clone));
	}
}

class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	double side;
	// default and one that sets side length
	public Octagon() {
		this(1);
	}
	public Octagon(double side) {
		this.side = side;
	}
	
	/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}
	/** Retrieves area of octagon */
	public double getArea() {
		return (2 + 4/Math.sqrt(2))* side * side;
	}
	// octagons are compared based on their area
	@Override
	public int compareTo(Octagon arg0) {
		if (this.getArea() > arg0.getArea()) {
			return 1;
		} else if (this.getArea() < arg0.getArea()) {
			return -1;
		}
		return 0;
	}
	// implement comparable method
	@Override
    protected Object clone()  {
		// create brand new stack
        Octagon newOcta = null;
        // cry to clone
        try {
            newOcta = (Octagon) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // set list to the new stack and retrieve it
        newOcta.side = side;
        return newOcta;
    }
	@Override
	public String toString() {
		return super.toString() +
				"\n\tside: " +
				this.side +
				"\n\tarea: " +
				getArea();
	}
}
/** Simple geometric object class */
class GeometricObject {
	// geometric object have color and date created
	private String color;
	private java.util.Date dateCreated;
	// default constructor and one that takes color as argument
	public GeometricObject() {
		this("white");
	}
	public GeometricObject(String color) {
		dateCreated = new java.util.Date();
		this.color = color;
	}
	// accessors and mutators
	public String getColor() {
		return color;
	}
	public java.util.Date getDateCreated() {
		return this.dateCreated;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "\tcolor: " +
				this.getColor() +
				"\n\tdate: " +
				getDateCreated();
	}
}
