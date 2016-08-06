/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

public class Zadatak_04 {
	public static void main(String[] args) {
		String userString = "Beijing Chicago";
		boolean fliper = false;
		for (char ch : userString.toCharArray()) {
			if (Character.isAlphabetic(ch)) System.out.printf("%s", (fliper = !fliper) ? ch + "" : "");
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
