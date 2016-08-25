
package zadaci_25_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	
	public static void main(String[] args) {
		MyString1 string = new MyString1("test string");
		System.out.println(string);
	}

}

class MyString1 {
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
	public char charAt(int index) {
		return this.value[index];
	}
	public int length() {
		return this.value.length;
	}
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
		char[] values = new char[end - begin];
		for (int i = 0; i < values.length; i++) {
			values[i] = this.value[begin];
			begin++;
		}
		return new MyString1(values);
	}
//	public MyString1 toLowerCase();
//	public boolean equals(MyString1 s);
//	public static MyString1 valueOf(int i);
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (char c : value) {
			str.append(c);
		}
		return str.toString();
		
	}
	
}