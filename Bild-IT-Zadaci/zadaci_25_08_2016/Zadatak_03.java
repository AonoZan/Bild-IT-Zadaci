
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**Method tests custom MyCharacter class implementation.*/
	public static void main(String[] args) {
		char c1 = 'Z';
		char c2 = 'b';
		Character ch1 = new Character(c1);
		MyCharacter ch2 = new MyCharacter(c1);
		
		System.out.printf("For characters %c and %c...\n", c1, c2);
		
		System.out.print("System compare: ");
		System.out.println(ch1.compareTo(c2));
		
		System.out.print("Custom compare: ");
		System.out.println(ch2.compareTo(c2));
		
		System.out.print("System equals: ");
		System.out.println(ch1.equals(c2));
		
		System.out.print("Custom equals: ");
		System.out.println(ch2.equals(c2));
		
	}
}
/**
 * Simple custom implementation if the class Character.
 * 
 * @author AonoZan
 *
 */
class MyCharacter {
	// contants for max and min value
	public final int MAX_VALUE = 65535;
	public final int MIN_VALUE = 0;
	private char value = 0;
	
	MyCharacter() {
		this(0);
	}
	MyCharacter(int n) {
		// if wrong value for char print message
		if (n >= MIN_VALUE && n <= MAX_VALUE) {
			this.value = (char)(n);
		} else {
			System.out.println("Error: int value for char is wrong.");
		}
	}
	MyCharacter(char c) {
		this.value = c;
	}
	public char getValue() {
		return this.value;
	}
	/**Method for checking if character equals to other character*/
	public boolean equals(MyCharacter ch) {
		return this.value == ch.getValue() ? true : false;
	}
	/**Method for comparing characters with this value*/
	public int compareTo(char ch) {
		return this.value - ch;
	}
	// method toString so that we could print values easily
	@Override
	public String toString() {
		return this.value + "";
	}
}