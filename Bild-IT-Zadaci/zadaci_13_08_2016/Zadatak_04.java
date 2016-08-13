/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_13_08_2016;

public class Zadatak_04 {
	// method for reversing numbers
	public static int reverse(int n){
		int r = 0;
		while (n != 0) {
			r = (r * 10) + (n % 10);
			n /= 10;
		}
		return r;
	}
	// method checks if number is palindrome (same as reverse)
	public static boolean isPalindrome(int n) {
		return n == reverse(n) ? true : false;
	}
	// method checks if number is prime
	public static boolean isPrime(int n) {
		//check if n is a multiple of 2
	    if (n%2==0 && n != 2 || n == 1) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	/**
	 * Program prints first Palindrome prime numbers.
	 * Palindrome prime number is number that is prime even when it's value is reversed.
	 * @param args
	 */
	public static void main(String[] args) {
		// go trough numbers and stop when counter reaches 100
		for (int i = 0, counter = 0; counter < 100; i++) {
			// if current number is palindrome
			if (isPalindrome(i)) {
				// if current number and it's reversed value are primes
				if (isPrime(i) && isPrime(reverse(i))) {
					// print number and count it 
					System.out.print(i + " ");
					counter++;
					// add new line every 10-th number
					if (counter % 10 == 0) System.out.println();
				}
			}
		}
	}
}
