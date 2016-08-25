
package zadaci_25_08_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	public static String[] split(String s, String regex) {
		String[] list;
		StrList listBuffer = new StrList();
		char a, b, r = regex.charAt(0);
		int index;
		for (int i = 0; i < s.length(); i++) {
			a = s.charAt(i);
			if (a == r) {
				index = 0;
				do {
					a = s.charAt(index);
					b = regex.charAt(index);
					index++;
				} while (a == b || index < regex.length());
				
				if (index == regex.length()) {
					if (i > 0) {
						listBuffer.add(s.substring(0, i));
					}
					listBuffer.add(regex);
					s = s.substring(i + regex.length(), s.length());
					i = 0;
				}
			} else if (i == s.length() - 1){
				listBuffer.add(s);
			}
		}
		list = new String[listBuffer.getLength()];
		for (int i = 0; i < list.length; i++) {
			list[i] = listBuffer.get(i);
		}
		return list;
	}
	public static void main(String[] args) {
		String str = "ja#ti#on#ona#ono#mi#vi#oni#";
		String[] str1 = str.split("#");
		String[] str2 = split(str, "#");
		
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
		
		
		
//		StrList list = new StrList();
//		
//		for (String string : str) {
//			list.add(string);
//		}
//		for (int i = list.getLength(); i > 0; i--) {
//			System.out.print (list.pop());
//		}
	}

}
class StrList{
	private String[] list;
	private int currentSize;
	StrList() {
		this(4);
	}
	StrList(int length) {
		this.list = new String[length];
	}
	public int getLength() {
		return this.currentSize;
	}
	public String[] getList() {
		return this.list;
	}
	public String get(int index) {
		return this.list[index];
	}
	public void add(String str) {
		if (currentSize >= this.list.length) {
			String[] newList = new String[currentSize * 2];
			java.lang.System.arraycopy(list, 0, newList, 0, currentSize);
			list = newList;
		}
		list[currentSize] = str;
		currentSize++;
	}
	public String pop() {
		return list[--currentSize];
	}
}
