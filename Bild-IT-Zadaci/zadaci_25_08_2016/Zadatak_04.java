
package zadaci_25_08_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**Custom string split method that returns list with regex included.*/
	public static String[] split(String s, String regex) {
		// create list and list buffer
		String[] list;
		StrList listBuffer = new StrList();
		// create characters for comparison
		char a, b, r = regex.charAt(0);
		int index;
		// loop trough string
		for (int i = 0; i < s.length(); i++) {
			// set current iteration character
			a = s.charAt(i);
			// if current character is same as first character from regex
			if (a == r) {
				// reset index and loop to check if there is whole regex
				index = 0;
				do {
					a = s.charAt(index);
					b = regex.charAt(index);
					index++;
				// loop until same chars and index is less than regex length
				} while (a == b && index < regex.length());
				// if index length is same as regex whole regex is found
				if (index == regex.length()) {
					// add if something before regex
					if (i > 0) {
						listBuffer.add(s.substring(0, i));
					}
					// add regex
					listBuffer.add(regex);
					// delete everything before regex including regex
					s = s.substring(i + regex.length(), s.length());
					// set iteration to -1 so that after loop it's at 0
					i = -1;
				}
//			// else if string reaches end add string reminder
			} else if (i == s.length() - 1){
				listBuffer.add(s);
			}
		}
		// set list length and copy from buffer
		list = new String[listBuffer.getLength()];
		for (int i = 0; i < list.length; i++) {
			list[i] = listBuffer.get(i);
		}
		// return list
		return list;
	}
	/**
	 * Program tests split() method with some string.
	 * @param args
	 */
	public static void main(String[] args) {
		// create string and two lists using split method
		String str = "ja##ti#on#ona#ono#mi#vi#oni#";
		String[] str1 = str.split("#");
		String[] str2 = split(str, "#");
		
		// print stats for both lists
		System.out.println("Built in split len = " + str1.length);
		for (String string : str1) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		System.out.println("Custom split len = " + str2.length);
		for (String string : str2) {
			System.out.print(string + " ");
		}
		System.out.println();
	}
}
/**
 * Simple list buffer for String type.
 * 
 * @author AonoZan
 *
 */
class StrList{
	// create list and size
	private String[] list;
	private int currentSize;
	// default constructor creates list of 16 places
	StrList() {
		this(16);
	}
	StrList(int length) {
		this.list = new String[length];
	}
	public int getLength() {
		return this.currentSize;
	}
	// list getter
	public String[] getList() {
		return this.list;
	}
	// item at index getter
	public String get(int index) {
		return this.list[index];
	}
	/**Method adds item to the list.*/
	public void add(String str) {
		// if list reaches near full double size of the list
		if (currentSize >= this.list.length) {
			String[] newList = new String[currentSize * 2];
			java.lang.System.arraycopy(list, 0, newList, 0, currentSize);
			list = newList;
		}
		// add item to the list and update size
		list[currentSize] = str;
		currentSize++;
	}
	/**Method returns list item.*/
	public String pop() {
		return list[--currentSize];
	}
}
