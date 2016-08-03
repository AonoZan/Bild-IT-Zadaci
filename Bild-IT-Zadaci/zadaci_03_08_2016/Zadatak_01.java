/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

public class Zadatak_01 {
	/**
	 * Method that checks if any number is prime.
	 * Method loops trough all possible combination to find out
	 * if number is divisable by any and if finds divider returns false otherwise true is returned.
	 * @param number should be positive number bigger than 1
	 * @return true if number is prime and false if it's not
	 * @see  <a href="www.scsb.org/trh/prime/">Prime numbers</a>
	 */
	public static boolean isPrime(int number){
		// if number is less than one calculation can not proceed return false
		if (number <= 1) {
			System.out.println("isPrime argument can't be 1, 0 or negative.");
			return false;
		}
		// if number is any of the first few primes return it immediately
		if (number == 2 || number == 3) return true;
		// loop from 2 to half of the number value
		// if number is divisable at any point that means its not prime
		for (int i = 2; i <= number/2; i++) {
			if (number % i == 0) return false;
		}
		// or return true if its not divisable
		return true;
	}
	/**
	 * Method that prints all primes in range.
	 * Primes that are found in range are printed and separated with space character
	 * @param from any number to be used as starting point for searching primes
	 * @param to any number for ending point in search
	 */
	public static void printPrimesInRange(int from, int to) {
		// if arguments are of the same value add one to second
		// so that calculation is done at least once
		if (from == to) {
			to++;
		// if first argiment is bigger switch
		} else if (from > to) {
			to += from;
			from = to - from;
			to -= from;
		}
		// go trough range and print only ones that are primes with space in between
		for (int i = from; i <= to; i++) {
			if (isPrime(i)) System.out.print(i + " ");
		}
	}
	/**
	 * Method for printing primes in range that also takes care of how much of them are printed per line.
	 * Primes are printed and formated based on the biggest prime possible in range.
	 * That means if biggest prime in range is three digit number all primes printed will be same length(three).
	 * @param from can be any number and it will be used as a starting point for range
	 * @param to can be any number, it's for ending point in range
	 * @param newLine is number of primes printed per line
	 */
	public static void printPrimesInRange(int from, int to, int newLine) {
		// if arguments are of the same value add one to second
		// so that calculation is done at least once
		if (from == to) {
			to++;
		// if first argiment is bigger switch
		} else if (from > to) {
			to += from;
			from = to - from;
			to -= from;
		}
		// go trough range and check if any of them is prime
		for (int i = from, primeCointer = 0; i <= to; i++) {
			if (isPrime(i)) {
				// if it's prime print it but align using to variable so that all numbers are alignet correctly
				System.out.printf("%"+(String.valueOf(to).length()-1)+"d ", i);
				// count found primes and if it's divisable with new line hop to new line
				primeCointer++;
				if (primeCointer % newLine == 0) System.out.println();
			}
		}
	}
	/**
	 * Simple main method for testing printPrimesInRange().
	 * Simulation tests first 1000 numbers and prints 10 per line
	 * @param args
	 */
	public static void main(String[] args) {
		// print first 1000 primes 10 per line
		printPrimesInRange(2, 1000, 10);
	}
}
