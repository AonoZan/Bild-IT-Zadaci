
package zadaci_05_09_2016;

import java.math.BigInteger;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	public static void main(String[] args) {
		Rational rat = new Rational(15, 78);
		BigRational bigRat = new BigRational(new BigInteger("15"), new BigInteger("78"));
		
		System.out.printf("Rational:\n"
				+ "\tnumerator: %d\n"
				+ "\tdenominator: %d\n"
				, rat.getNumerator()
				, rat.getDenominator()
				);

		System.out.printf("BigRational:\n"
				+ "\tnumerator: %s\n"
				+ "\tdenominator: %s\n"
				, bigRat.getNumerator().toString()
				, bigRat.getDenominator().toString()
				);
		
	}
}

class BigRational {//extends Number implements Comparable<Rational> {
//	private static final long serialVersionUID = 1L;
	// Data fields for numerator and denominator
	private BigInteger numerator;
	private BigInteger denominator;

	/** Construct a rational with default properties */
	public BigRational() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}

	/** Construct a rational with specified numerator and denominator */
	public BigRational(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = gcd(numerator, denominator);
		this.numerator = new BigInteger(((denominator.compareTo(BigInteger.ZERO) > 0) ? 1 : -1) + "").multiply(numerator).divide(gcd);
		this.denominator = denominator.abs().divide(gcd);
	}

	/** Find GCD of two numbers */
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n.abs();
		BigInteger n2 = d.abs();
		BigInteger gcd = BigInteger.ONE;

		for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
			if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0 && n2.remainder(k).compareTo(BigInteger.ZERO) == 0)
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public BigInteger getNumerator() {
		return new BigInteger(numerator.toString());
	}

	/** Return denominator */
	public BigInteger getDenominator() {
		return new BigInteger(denominator.toString());
	}
//
//	/** Add a rational number to this rational */
//	public Rational add(Rational secondRational) {
//		long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
//		long d = denominator * secondRational.getDenominator();
//		return new Rational(n, d);
//	}
//
//	/** Subtract a rational number from this rational */
//	public Rational subtract(Rational secondRational) {
//		long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
//		long d = denominator * secondRational.getDenominator();
//		return new Rational(n, d);
//	}
//
//	/** Multiply a rational number by this rational */
//	public Rational multiply(Rational secondRational) {
//		long n = numerator * secondRational.getNumerator();
//		long d = denominator * secondRational.getDenominator();
//		return new Rational(n, d);
//	}
//
//	/** Divide a rational number by this rational */
//	public Rational divide(Rational secondRational) {
//		long n = numerator * secondRational.getDenominator();
//		long d = denominator * secondRational.numerator;
//		return new Rational(n, d);
//	}
//
//	@Override
//	public String toString() {
//		if (denominator == 1)
//			return numerator + "";
//		else
//			return numerator + "/" + denominator;
//	}
//
//	@Override // Override the equals method in the Object class
//	public boolean equals(Object other) {
//		if ((this.subtract((Rational) (other))).getNumerator() == 0)
//			return true;
//		else
//			return false;
//	}
//
//	@Override // Implement the abstract intValue method in Number
//	public int intValue() {
//		return (int) doubleValue();
//	}
//
//	@Override // Implement the abstract floatValue method in Number
//	public float floatValue() {
//		return (float) doubleValue();
//	}
//
//	@Override // Implement the doubleValue method in Number
//	public double doubleValue() {
//		return numerator * 1.0 / denominator;
//	}
//
//	@Override // Implement the abstract longValue method in Number
//	public long longValue() {
//		return (long) doubleValue();
//	}
//
//	@Override // Implement the compareTo method in Comparable
//	public int compareTo(Rational o) {
//		if (this.subtract(o).getNumerator() > 0)
//			return 1;
//		else if (this.subtract(o).getNumerator() < 0)
//			return -1;
//		else
//			return 0;
//	}
}