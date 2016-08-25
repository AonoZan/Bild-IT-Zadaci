
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**Simple method that tests MyString1 class.*/
	public static void main(String[] args) {
		MyString1 string = new MyString1("teST");
		
		System.out.print("This string: ");
		System.out.println(string);
		System.out.print("To lower case: ");
		System.out.println(string.toLowerCase());
		System.out.print("Substring (0, 2): ");
		System.out.println(string.substring(0, 2));
		System.out.print("Eqials to \"test 1\": ");
		System.out.println(string.equals(new MyString1("test 1")));
		System.out.print("Lower case and equals to \"test\": ");
		System.out.println(string.toLowerCase().equals(new MyString1("test")));
		System.out.print("Value of number 69: ");
		System.out.println(MyString1.valueOf(69));
	}
}
/**
 * Simple custom String implementation.
 * 
 * @author AonoZan
 *
 */
class MyString1 {
	// list that stores values
	private char[] value;
	
	MyString1() {
		this.value = null;
	}
	MyString1(String string) {
		this(string.toCharArray());
	}
	MyString1(char[] chars) {
		if (chars == null) {
			this.value = null;
			return;
		}
		this.value = chars;
	}
	/**Method that returns character at specific position*/
	public char charAt(int index) {
		return this.value[index];
	}
	/**Method that returns length of string*/
	public int length() {
		return this.value.length;
	}
	/**
	 * Returns substring of this string.
	 * 
	 * @param begin this should be lower than end and string length
	 * @param end this should be greater than begin but lower than string length
	 * @return
	 */
	public MyString1 substring(int begin, int end){
		// wrong size arguments return null
		if ((begin + end) > length()
				|| begin < 0
				|| end < 0) {
			System.out.println("can't return substring.(IndexOutOfRange)");
			return null;
		}
		// switch values if end is less than begin 
		if (begin > end) {
			begin += end;
			end = begin - end;
			begin -= end;
		}
		// create new list with required length
		char[] values = new char[end - begin];
		// copy only characters from begin to the end to the new list
		for (int i = 0; i < values.length; i++) {
			values[i] = this.value[begin];
			begin++;
		}
		return new MyString1(values);
	}
	/**Returns this string but all characters in lower case.*/
	public MyString1 toLowerCase() {
		char[] newValue = new char[length()];
		for (int i = 0; i < newValue.length; i++) {
			newValue[i] = Character.toLowerCase(this.value[i]);
		}
		return new MyString1(newValue);
	}
	/**Checks if strings are equal*/
	public boolean equals(MyString1 s) {
		// if argument is null check if this value is null also
		if (s == null) {
			return this.value == null ? true : false;
		// if not equal length return false
		} else if (s.length() != length()) {
			return false;
		}
		// loop trough all values
		for (int i = 0; i < value.length; i++) {
			// if any characters at same position aren't equal return false
			if (charAt(i) != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Returns character as string from integer.
	 * @param i number in range 0 - Char.MAX_VALUE.
	 * @return character as string or null if illegal argument.
	 */
	public static MyString1 valueOf(int i) {
		// for illegal values return null
		if (i < 0 || i > Character.MAX_VALUE) {
			return null;
		}
		return new MyString1(new char[]{(char)i});
	}
	// method toString so that we could print values easily
	@Override
	public String toString() {
		// create new string buffer and add all values to it
		StringBuffer str = new StringBuffer();
		for (char c : value) {
			str.append(c);
		}
		// return buffer converted to string
		return str.toString();
	}
}