
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {

	public static void main(String[] args) {
		
		String a = "aaabefa";
		String b = "aaabefa";
		System.out.println(a.compareTo(b));
		
		MyString2 a2 = new MyString2(a);
		System.out.println(a2.compare(b));
	}

}

class MyString2 {
	private char[] value;
	public MyString2() {
		this.value = null;
	}
	public MyString2(String s) {
		this.value = s.toCharArray();
	}
	/**Method compares two strings and*/
	public int compare(String s) {
		// check if this or argument string is null
		if (s == null) {
			// if both null return 0 else -2
			return this.value == null ? 0 : -2;
		}
		int e = 0;
		if (this.value.length != s.length()) {
			e = this.value.length - s.length();
		}
		int range = 0;
		if (this.value.length > s.length()) {
			range = s.length();
		} else {
			range = this.value.length;
		}
		char a, b;
		for (int i = 0; i < range; i++) {
			a = value[i];
			b = s.charAt(i);
			if (a != b) {
				if (a > b) {
					return (int)(a - b);
				} else {
					return -(int)(b - a);
				}
			}
		}
		return 0 + e;
	}
//	public MyString2 substring(int begin);
//	public MyString2 toUpperCase();
//	public char[] toChars();
//	public static MyString2 valueOf(boolean b);
}