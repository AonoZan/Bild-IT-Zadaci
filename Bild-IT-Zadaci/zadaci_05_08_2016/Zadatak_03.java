/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_03 {
	public static String prefix(String first, String second) {
		// if any of argument is null return null
		if (first == null || first.length() == 0) {
			System.out.println("Cant return prefix(first argument null or 0 length).");
			return "";
		} else if (second == null || second.length() == 0) {
			System.out.println("Cant return prefix(second argument null or 0 length).");
			return "";
		}
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
			if (first.charAt(i) == second.charAt(i)) prefix.append(first.substring(i, i + 1));
			else break;
		}
		return prefix.toString();
	}
	public static void main(String[] args) {
//		System.out.println("asdasdef".equals("asdasdf"));
		System.out.println("Enter two strings.");
		System.out.print("Enter first string: ");
		String firstString = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		System.out.print("Enter second string: ");
		String secondString = zadaci_01_08_2016.Zadatak_02.userInput.nextLine();
		
		String prefix = prefix(firstString, secondString);
		System.out.printf("%s\n", prefix.length() > 0 ? "Prefix for both strings is: \"" + prefix + "\"" : "No prefix.");
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
