/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_05 {
	public static boolean isSubstring(String string, String substring) {
		for (int i = 0; i < string.length() - substring.length(); i++) {
			if (substring.equals(string.substring(i, i + substring.length()))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isSubstring("ABCD", "BC"));
	}
}
