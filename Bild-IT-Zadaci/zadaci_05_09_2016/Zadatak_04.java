
package zadaci_05_09_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Program creates few complex numbers and performs operations on them. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt for first and second complex number
		System.out.print("Enter first complex number: ");
		Complex first = new Complex(input.nextDouble(), input.nextDouble());
		
		System.out.print("Enter second complex number: ");
		Complex second = new Complex(input.nextDouble(), input.nextDouble());
		
		// print output of all operations
		Complex addition = first.add(second);
		System.out.printf("(%.1f + %.1fi) + (%.1f + %.1fi) = %.1f + %.1fi\n"
				, first.getA()
				, first.getB()
				, second.getA()
				, second.getB()
				, addition.getA()
				, addition.getB()
				);
		Complex substraction = first.subtract(second);
		System.out.printf("(%.1f + %.1fi) - (%.1f + %.1fi) = %.1f + %.1fi\n"
				, first.getA()
				, first.getB()
				, second.getA()
				, second.getB()
				, substraction.getA()
				, substraction.getB()
				);
		Complex multiplication = first.multiply(second);
		System.out.printf("(%.1f + %.1fi) * (%.1f + %.1fi) = %.1f + %.1fi\n"
				, first.getA()
				, first.getB()
				, second.getA()
				, second.getB()
				, multiplication.getA()
				, multiplication.getB()
				);
		Complex division = first.divide(second);
		System.out.printf("(%.1f + %.1fi) / (%.1f + %.1fi) = %.1f + %.1fi\n"
				, first.getA()
				, first.getB()
				, second.getA()
				, second.getB()
				, division.getA()
				, division.getB()
				);
		
		input.close();
	}
}
/** Complex class that implements Clone-able */
class Complex implements Cloneable {
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
	
	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}
	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}
	// addition
	public Complex add(Complex other) {
		return new Complex(this.a + other.a, this.b + other.b);
	}
	// subtraction
	public Complex subtract(Complex other) {
		return new Complex(this.a - other.a, this.b - other.b);
	}
	// multiplication
	public Complex multiply(Complex other) {
		return new Complex(this.a * other.a - this.b * other.b
				,this.b * other.a + this.a * other.b);
	}
	
	// division
	public Complex divide(Complex other) {
		return new Complex
				( (this.a * other.a + this.b * other.b) / (Math.pow(other.a, 2) + Math.pow(other.b, 2))
				, (this.b * other.a - this.a * other.b) / (Math.pow(other.a, 2) + Math.pow(other.b, 2)) 
				);
	}
	
	// implement comparable method
	@Override
    protected Object clone()  {
		// create brand new complex
        Complex newComplex = null;
        // try to clone
        try {
            newComplex = (Complex) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // set values
        newComplex.a = a;
        newComplex.b = b;
        
        return newComplex;
    }
	@Override
	public String toString() {
		// return onl a if b is 0
		if (this.b == 0) return this.a + "";
		// return numbers in format (a + bi)
		return String.format("(%.2f + %.2fi)", this.a, this.b);
	}
}