
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**Program tests MyStringBuilder1 class.*/
	public static void main(String[] args) {
		String s1 = "1234";
		String s2 = "567890";
		MyStringBuilder1 str = new MyStringBuilder1(s1);
		MyStringBuilder1 str2 = new MyStringBuilder1(s2);
		str = str.append(str2);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		str2 = str.toLowerCase();
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(str2.charAt(i));
		}
		System.out.println();

		str2 = str.substring(2, 6);
//		str2 = str.substring(4, 8);
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(str2.charAt(i));
		}
		System.out.println();
		System.out.println((s1+s2).substring(2, 6));
//		System.out.println((s1+s2).substring(4, 8));
		
	}
}
/**
 * Custom implementation if the StringBuilder class.
 * 
 * @author AonoZan
 *
 */
class MyStringBuilder1 {
	// store calues and length of string
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
	/**Method for retriving character at some index.*/
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
	public MyStringBuilder1 toLowerCase() {
		String[] newList = new String[this.list.length];
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < newList.length; i++) {
			buffer.setLength(0);
			for (char c : this.list[i].toCharArray()) {
				buffer.append(Character.toLowerCase(c));
			}
			newList[i] = buffer.toString();
		}
		return new MyStringBuilder1(newList);
	}
	public MyStringBuilder1 substring(int begin, int end) {
		end -= begin;
		StringBuffer buffer = new StringBuffer();
		for (String string : list) {
			if (begin > 0) {
				if (begin >= string.length()) {
					begin -= string.length();
				} else {
					buffer.append(string.substring(begin, string.length()));
					end -= end - begin;
					begin = 0;
				}
				continue;
			}
			if (end > 0) {
				if (end >= string.length()) {
					buffer.append(string);
					end -= string.length();
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