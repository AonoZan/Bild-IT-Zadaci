
package zadaci_05_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	public static void main(String[] args) {
	}
}

class Complex {
	private double a;
	private double b;
	public Complex() {
		this(0);
	}
	public Complex(double a) {
		this(a, 0);
	}
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public Complex add(Complex other) {
		return new Complex(this.a + other.a, this.b + other.b);
	}
	public Complex substract(Complex other) {
		return new Complex(this.a - other.a, this.b - other.b);
	}
}