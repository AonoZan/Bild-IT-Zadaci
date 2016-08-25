
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**Method tests MyString2 class.*/
	public static void main(String[] args) {
		String a = "abcDy";
		String b = "abcdefgh";
		System.out.printf("For strings \"%s\" and \"%s\":\n"
				, a, b);
		
		System.out.print("System compareTo(): ");
		System.out.println(a.compareTo(b));
		System.out.print("Custom compare(): ");
		MyString2 a2 = new MyString2(a);
		System.out.println(a2.compare(b));
		
		System.out.print("Substring of first string with 2: ");
		System.out.println(a2.substring(2));
		System.out.print("First string to upper case: ");
		System.out.println(a2.toUpperCase());
		
		System.out.print("Boolean valueOf(): ");
		System.out.print(MyString2.valueOf(true) + " ");
		System.out.println(MyString2.valueOf(false));
	}
}
/**
 * Custom String implementation.
 * Can store maximum of Character.MAX_VALUE characters.
 * 
 * @author AonoZan
 *
 */
class MyString2 {
	// variable for storing all values
	private char[] value;
	
	public MyString2() {
		this.value = null;
	}
	public MyString2(String s) {
		this(s.toCharArray());
	}
	public MyString2(char[] value) {
		this.value = value;
	}
	/**Method compares two strings and returns difference as integer.
	 * Same as compareTo() from String class.
	 */
	public int compare(String s) {
		// check if this or argument string is null
		if (s == null) {
			// if both null return 0 else -2
			return this.value == null ? 0 : -2;
		}
		// create variables
		int range = 0;
		char ch1, ch2;
		// get range from smaller string
		if (this.value.length > s.length()) {
			range = s.length();
		} else {
			range = this.value.length;
		}
		// loop to range
		for (int i = 0; i < range; i++) {
			// get both characters
			ch1 = value[i];
			ch2 = s.charAt(i);
			// if characters not equal
			if (ch1 != ch2) {
				// return subtraction of thos etwo
				return (int)(ch1 - ch2);
			}
		}
		// strings can have same content at same indexes
		// but different length return difference
		return this.value.length - s.length();
	}
	/**
	 * Method returns substring from argument to the end.
	 * @param begin
	 * @return
	 */
	public MyString2 substring(int begin) {
		// if invalid argument return null
		if (begin > this.value.length
				|| begin < 0) {
			System.out.println("Can't return substring.(IndexOutOfRange)");
			return null;
		// if equal as length return new empty string
		} else if (begin == this.value.length) {
			return new MyString2("");
		}
		// create list with appropriate subtracted size
		char[] newList = new char[this.value.length - begin];
		for (int i = 0, index = begin; i < newList.length; i++, index++) {
			newList[i] = this.value[index];
		}
		// return new string
		return new MyString2(newList);
	}
	/**Method returns this string all characters as upper case.*/
	public MyString2 toUpperCase() {
		// create new list and add all characters but set to upper case
		char[] newList = new char[this.value.length];
		for (int i = 0; i < newList.length; i++) {
			newList[i] = Character.toUpperCase(this.value[i]);
		}
		return new MyString2(newList);
	}
	/**Method returns string as char list.*/
	public char[] toChars() {
		return this.value;
	}
	/**Method returns boolean value as string*/
	public static MyString2 valueOf(boolean b) {
		MyString2 newStr = b ? new MyString2("true") : new MyString2("false");
		return newStr;
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