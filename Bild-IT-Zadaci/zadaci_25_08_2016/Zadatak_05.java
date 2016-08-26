
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**Program tests MyStringBuilder1 class.*/
	public static void main(String[] args) {
		String s1 = "Simple string";
		String s2 = "Another one";
		MyStringBuilder1 str = new MyStringBuilder1(s1);
		MyStringBuilder1 str2 = new MyStringBuilder1(s2);
		System.out.printf("For strings \"%s\" and \"%s\"...\n\n", s1, s2);
		
		System.out.print("Append strings: ");
		str = str.append(str2);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		
		System.out.print("Make lower case: ");
		str2 = str.toLowerCase();
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(str2.charAt(i));
		}
		System.out.println();

		System.out.print("Custom substring(2, 6): ");
		str2 = str.substring(2, 6);
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(str2.charAt(i));
		}
		System.out.println();
		
		System.out.print("System substring: ");
		System.out.println((s1+s2).substring(2, 6));
		
	}
}
/**
 * Custom implementation if the StringBuilder class.
 * 
 * @author AonoZan
 *
 */
class MyStringBuilder1 {
	// store values and length of string
	private String[] list;
	private int length;
	
	public MyStringBuilder1(String s) {
		this(new String[]{s});
	}
	public MyStringBuilder1(String[] list) {
		this.list = list;
		this.length = sum(list);
	}
	public String[] asArray() {
		return this.list;
	}
	// return length of the string
	public int length() {
		return this.length;
	}
	// calculate length of characters in list
	private int sum(String[] list) {
		int sum = 0;
		for (String string : list) {
			sum += string.length();
		}
		return sum;
	}
	/**
	 * Method for appending another string to this one.
	 * @param s
	 * @return New MyStringBuilder1 object.
	 */
	public MyStringBuilder1 append(MyStringBuilder1 s) {
		// create new list and copy this list to it
		String[] newList = new String[list.length + s.asArray().length];
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		// get list that need to be appended and add to the new list
		String[] appendList = s.asArray();
		for (int i = 0; i < appendList.length; i++) {
			newList[i + list.length] = appendList[i];
		}
		// return new MyStringBuilder1 object with new list
		return new MyStringBuilder1(newList);
	}
	/**Method for appending int value to the string.*/
	public MyStringBuilder1 append(int i) {
		return append(new MyStringBuilder1(i + ""));
	}
	/**Method for retrieving character at some index.*/
	public char charAt(int index) {
		// check if argument is negative and retrieve 0 if yes
		if (index < 0) {
			System.out.println("Can't retrive charAt().(negative arg)");
			return 0;
		}
		// go trough whole list
		for (String string : list) {
			// if index is bigger than item in list subtract index
			if (index >= string.length()) {
				index -= string.length();
			// when index gets lower than list item
			// retrieve character from list item
			} else {
				return string.charAt(index);
			}
		}
		// if index is greater than 0 after loop then index is out of range
		if (index > 0) {
			System.out.println("Can't retrive charAt().(IndexOutOfRange)");
		}
		return 0;
	}
	/**Method retrieves new string but with lower case.*/
	public MyStringBuilder1 toLowerCase() {
		// create new list and buffer
		String[] newList = new String[this.list.length];
		StringBuffer buffer = new StringBuffer();
		// loop over old list
		for (int i = 0; i < newList.length; i++) {
			// reset buffer and loop over item in list
			buffer.setLength(0);
			for (char c : this.list[i].toCharArray()) {
				// add every character to the buffer but with lower case
				buffer.append(Character.toLowerCase(c));
			}
			// add buffer to the new list
			newList[i] = buffer.toString();
		}
		return new MyStringBuilder1(newList);
	}
	/**Method returns new substring.*/
	public MyStringBuilder1 substring(int begin, int end) {
		// end is length from begin index
		end -= begin;
		// create buffer and loop over list of strings
		StringBuffer buffer = new StringBuffer();
		for (String string : list) {
			// if still not at begin index of the list
			if (begin > 0) {
				// pass this string begin is bigger subtract length to carry on
				if (begin >= string.length()) {
					begin -= string.length();
				// if substring can be extracted append to buffer and reset both begin and end
				} else if (begin + end <= string.length()) {
					buffer.append(string.substring(begin, begin + end));
					begin = 0;
					end = 0;
				// if it's not add substring to buffer
				} else {
					buffer.append(string.substring(begin, string.length()));
					end -= end - begin;
					begin = 0;
				}
				continue;
			}
			// if still need to add strings
			if (end > 0) {
				// add whole string if end is greater than string length
				if (end >= string.length()) {
					buffer.append(string);
					end -= string.length();
				// or add substring
				} else {
					buffer.append(string.substring(0, end));
					end = 0;
					break;
				}
				continue;
			}
			break;
		}
		return new MyStringBuilder1(buffer.toString());
	}
	// method toString so that we could print values easily
	@Override
	public String toString() {
		// create new string buffer and add all values to it
		StringBuffer str = new StringBuffer();
		for (String s : list) {
			str.append(s);
		}
		// return buffer converted to string
		return str.toString();
	}
}