/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

public class Zadatak_03 {
	/**
	 * Method checks if number is prime or not and returns boolean value.
	 * @see <a href="https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/">How to determine prime number</a>
	 */
	//checks whether an int is prime or not.
	public static int isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0 && n != 2 || n == 1) return 0;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return 0;
	    }
	    return n;
	}
	/**
	 * Program prints all primes in range 1 100000.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("All primes form 0 to 100.000:\n");
		for (int i = 0, counter = 0; i < 100000; i++) {
			if (isPrime(i) != 0) {
				System.out.print(i + " ");
				counter++;
				if (counter % 10 == 0) System.out.println();
			}
		}
	}

}
