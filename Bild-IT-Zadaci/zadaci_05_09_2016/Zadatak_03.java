
package zadaci_05_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Parse Rational from string for example "7/8" */
	public static Rational parseRational(String string) {
		// split string on "/"
		String[] split = string.split("/");
		// parse int from string
		long n = Integer.parseInt(split[0]);
		long d = Integer.parseInt(split[1]);
		
		return new Rational(n, d);
	}
	/** Simple console Rational calculator. */
	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println("Usage: java Calculator operand1 operator operand2");
			System.exit(0);
		}
		// parse rational from arguments
		Rational rat1 = parseRational(args[0]);
		Rational rat2 = parseRational(args[2]);
		// create variable for result
		Rational result = new Rational();
		// do calculation based on operator from arguments
		switch (args[1]) {
		case "+":
			result = rat1.add(rat2);
			break;
		case "-":
			result = rat1.subtract(rat2);
			break;
		case "*":
			result = rat1.multiply(rat2);
			break;
		case "/":
			result = rat1.divide(rat2);
			break;
		default:
			System.out.printf("Operation %s is not supported.\n", args[1]);
			break;
		}
		// print result
		System.out.printf("%s %s %s = %d/%d"
				, args[0], args[1], args[2]
				, result.getNumerator()
				, result.getDenominator()
				);
	}
}

