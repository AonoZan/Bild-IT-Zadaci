
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Test method for class MyInteer
	 * @param args
	 */
	public static void main(String[] args) {
		// create one integer and do some benchmarking
		MyInteger integer = new MyInteger(13);
		System.out.printf("Number %d is even: %b"
				, integer.getValue()
				, integer.isEven());
		System.out.printf("Number %d is odd: %b"
				, integer.getValue()
				, integer.isOdd());
		System.out.printf("Number %d is prime: %b"
				, integer.getValue()
				, integer.isPrime());
		System.out.printf("Number %d is even: %b"
				, 54
				, MyInteger.isEven(54));
		System.out.printf("Number %d is odd: %b"
				, 54
				, MyInteger.isOdd(54));
		System.out.printf("Number %d is prime: %b"
				, 54
				, MyInteger.isPrime(54));
		System.out.println("String 43780 to integer: "
				+ MyInteger.parseInt("43780"));
	}
}
/**
 * Simple class that stores one integer.
 * Class has range of useful methods that are convenient.
 * @author AonoZan
 *
 */
class MyInteger {
	private int value;
	public MyInteger(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	// methods for checking if some numbers are even
	public boolean isEven() {
		return isEven(this.value);
	}
	public static boolean isEven(int n) {
		return n % 2 == 0 ? true : false;
	}
	public static boolean isEven(MyInteger number) {
		return isEven(number.value);
	}
	// for checking if odd
	public boolean isOdd() {
		return !isEven();
	}
	public static boolean isOdd(int n) {
		return !isEven(n);
	}
	public static boolean isOdd(MyInteger number) {
		return !isEven(number.value);
	}
	// for checking if prime or not
	public boolean isPrime() {
		return isPrime(this.value);
	}
	public static boolean isPrime(int n) {
		// check if number is only 
		if (n % 2 == 0 && n != 2 || n <= 1) {
			return false;
		}
		//if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static boolean isPrime(MyInteger number) {
		return isPrime(number.value);
	}
	// methods for checking if some number is equal to this class number
	public boolean equals(int n) {
		return this.value == n ? true : false;
	}
	public boolean equals(MyInteger number) {
		return equals(number.value);
	}
	/**
	 * Method for converting list of char values to integer.
	 * @param number
	 * @return
	 */
	public static int parseInt(char[] number) {
		// create parsed number and loop over list
		int parsed = 0;
		for (char c : number) {
			// if char is digit
			if (Character.isDigit(c)) {
				// shift number to the right
				// and assign char to the last digit
				parsed *= 10;
				parsed += c - 48;
			} else {
				//print error massage and return 0
				System.out.print("Illegal character in parseInt() ==> ");
				System.out.println(c);
				return 0;
			}
		}
		return parsed;
	}
	// method for parsing string into number
	public static int parseInt(String number) {
		return parseInt(number.toCharArray());
	}
}
