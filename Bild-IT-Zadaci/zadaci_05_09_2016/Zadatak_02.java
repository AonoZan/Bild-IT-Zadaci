
package zadaci_05_09_2016;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Program tests BigRational class. */
	public static void main(String[] args) {
		// create normal rational and big rational with same values
		Rational rat = new Rational(15, 78);
		BigRational bigRat = new BigRational(new BigInteger("15"), new BigInteger("78"));
		// print numerator and denominator of both objects
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
		// multiply both objects with same values
		Rational ratMul = rat.multiply(new Rational(45, 63));
		BigRational bigRatMul = bigRat.multiply(new BigRational(new BigInteger("45"), new BigInteger("63")));
		// print results
		System.out.printf("Rational multiply with (45, 63):\n"
				+ "\tnumerator: %d\n"
				+ "\tdenominator: %d\n"
				, ratMul.getNumerator()
				, ratMul.getDenominator()
				);
		System.out.printf("BigRational multiply with (45, 63):\n"
				+ "\tnumerator: %d\n"
				+ "\tdenominator: %d\n"
				, bigRatMul.getNumerator()
				, bigRatMul.getDenominator()
				);
	}
}
/** BigRational is class same as Rational only that here BigInteger is used instead. */
class BigRational extends Number implements Comparable<BigRational> {
	private static final long serialVersionUID = 1L;
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
	
	/** Construct rational from decimal. */
	// https://github.com/LuizGsa21/intro-to-java-10th-edition/blob/master/src/ToolKit/BigRational.java
	public BigRational(String decimal) {
		// get index of separator
        int index = (decimal.contains(".")) ? decimal.indexOf('.') : decimal.indexOf('/');
        BigInteger d;
        BigInteger n;
        // if string is in decimal form
        if (decimal.contains(".")) {
            int power = decimal.substring(index + 1, decimal.length()).length();
            d = new BigInteger((int)Math.pow(10,power) + "");
            n = new BigInteger(new StringBuilder(decimal).deleteCharAt(index).toString());
        } else {
            // if string contains '/'
            n = new BigInteger(decimal.substring(0, index));
            d = new BigInteger(decimal.substring(index + 1, decimal.length()));
        }

        BigInteger gcd = gcd(n, d);
        this.numerator = ((d.compareTo(BigInteger.ZERO) > 0) ? BigInteger.ONE : new BigInteger("-1")).multiply(n).divide(gcd);
        this.denominator = d.abs().divide(gcd);

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

	/** Add a rational number to this rational */
	public BigRational add(BigRational secondRational) {
		BigInteger n = numerator
				.multiply(secondRational.getDenominator())
				.add(denominator)
				.multiply(secondRational.getNumerator());
		BigInteger d = denominator
				.multiply(secondRational.getDenominator());
		return new BigRational(n, d);
	}

	/** Subtract a rational number from this rational */
	public BigRational subtract(BigRational secondRational) {
		BigInteger n = numerator
				.multiply(secondRational.getDenominator())
				.subtract(denominator)
				.multiply(secondRational.getNumerator());
		BigInteger d = denominator
				.multiply(secondRational.getDenominator());
		return new BigRational(n, d);
	}

	/** Multiply a rational number by this rational */
	public BigRational multiply(BigRational secondRational) {
		BigInteger n = numerator
				.multiply(secondRational.getNumerator());
		BigInteger d = denominator
				.multiply(secondRational.getDenominator());
		return new BigRational(n, d);
	}

	/** Divide a rational number by this rational */
	public BigRational divide(BigRational secondRational) {
		BigInteger n = numerator
				.multiply(secondRational.getDenominator());
		BigInteger d = denominator
				.multiply(secondRational.numerator);
		return new BigRational(n, d);
	}

	@Override
	public String toString() {
		if (denominator.compareTo(BigInteger.ONE) == 1)
			return numerator.toString() + "";
		else
			return numerator.toString() + "/" + denominator.toString();
	}

	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((BigRational) (other))).getNumerator().compareTo(BigInteger.ZERO) == 0)
			return true;
		else
			return false;
	}

	@Override // Implement the abstract intValue method in Number
	public int intValue() {
		return (int) doubleValue();
	}

	@Override // Implement the abstract floatValue method in Number
	public float floatValue() {
		return (float) doubleValue();
	}

	@Override // Implement the doubleValue method in Number
	public double doubleValue() {
		BigDecimal n = new BigDecimal(numerator);
		BigDecimal d = new BigDecimal(denominator);
		
		return n.divide(d, 0).doubleValue();
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long) doubleValue();
	}

	@Override // Implement the compareTo method in Comparable
	public int compareTo(BigRational o) {
		if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
			return 1;
		else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
			return -1;
		else
			return 0;
	}
}