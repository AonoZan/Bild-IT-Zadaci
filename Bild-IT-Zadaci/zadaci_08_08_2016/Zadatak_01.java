/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_08_08_2016;

public class Zadatak_01 {
	/**
	 * Program asks simple sum question of three numbers.
	 * @param args
	 */
	public static void main(String[] args) {
		// ask question but force to get correct answer, if correct print congrats message
		System.out.println("Enter correct answer:");
		zadaci_02_08_2016.Zadatak_02.askSimpleQuestion(new int[]{1, 9}, new String[]{"+", "+"}, true);
		System.out.println("Congratulation!");
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
