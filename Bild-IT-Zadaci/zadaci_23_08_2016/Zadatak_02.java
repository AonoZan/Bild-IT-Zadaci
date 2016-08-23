
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {

	public static void main(String[] args) {
		MyInteger integer = new MyInteger(4);
		System.out.println(integer.isPrime());
	}

}
class MyInteger {
	private int value;
	public MyInteger(int value) {
		super();
		this.value = value;
	}
	public boolean isEven() {
		return isEven(this.value);
	}
	public static boolean isEven(int n) {
		return n % 2 == 0 ? true : false;
	}
	public static boolean isEven(MyInteger number) {
		return isEven(number.value);
	}
	public boolean isOdd() {
		return !isEven();
	}
	public static boolean isOdd(int n) {
		return !isEven(n);
	}
	public static boolean isOdd(MyInteger number) {
		return !isEven(number.value);
	}
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
}
