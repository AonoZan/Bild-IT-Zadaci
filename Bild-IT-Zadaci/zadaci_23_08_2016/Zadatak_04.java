
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**Program makes list of all primes less than 120 and prints in reverse*/
	public static void main(String[] args) {
		StackOfIntegers primes = new StackOfIntegers();
		// loop until 120 and add primes to the list
		for (int i = 0; i < 120; i++) {
			if (zadaci_12_08_2016.Zadatak_03.isPrime(i) != 0) {
				primes.push(i);
			}
		}
		// pop primes and print them
		for (int i = primes.getSize(); i > 0; i--) {
			System.out.print(primes.pop() + " ");
		}
	}
}
/**
 * Class for storing any length of numbers in array.
 * @author AonoZan
 *
 */
class StackOfIntegers {
	// variables for element list and size
	private int[] elements;
	private int size = 0;
	// default capacity of the list is 16
	private static final int DEFAULT_CAPACITY = 16;
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	public StackOfIntegers(int capacity) {
		super();
		this.elements = new int[capacity];
	}
	/** Push a new integer to the top of the stack */
	public void push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}

		elements[size++] = value;
	}

	/** Return and remove the top element from the stack */
	public int pop() {
		return elements[--size];
	}

	/** Return the top element from the stack */
	public int peek() {
		return elements[size - 1];
	}

	/** Test whether the stack is empty */
	public boolean empty() {
		return size == 0;
	}

	/** Return the number of elements in the stack */
	public int getSize() {
		return size;
	}
}
