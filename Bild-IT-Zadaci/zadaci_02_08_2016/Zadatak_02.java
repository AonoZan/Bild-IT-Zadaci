/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;

import zadaci_01_08_2016.Zadatak_05;

public class Zadatak_02 {
	/**
	 * Quick method for generating random numbers using two argument for range.
	 * Ii handles case when equal numbers are entered as argument,
	 * as well as if first argument is bigger than second
	 * @param from any number bigger or equal than this number
	 * @param to any number less or equal than this number
	 * @return random integer or zero if argument have same value
	 */
	public static int genRandInt(int from, int to){
		// if arguments have same value return 0 immediately
		if (from == to) return 0;
		// or if first argument is bigger than second switch them
		else if (from > to) {
			from = Math.min(from, to);
			to = Math.max(from, to);
		}
		// return random value in range
		return from + (int)(Math.random() * (to - from + 1));
	}
	/**
	 * Method for asking simple mathematical questions. Several opearations can be calculated.
	 * @param questionModifiers must be of length 3. First value tells how many questions will be asked,
	 * second and third are range for random number
	 * @param operation holds any number of srting values(operations) between numbers, can be any number of "+", "-"
	 */
	public static void askSimpleQuestion(int[] questionModifiers, String[] operation) {
		// make sure that at least one question and operation is asked and used 
		if (questionModifiers == null || questionModifiers.length != 3) questionModifiers = new int[]{1, 1, 9};
		if (operation == null || operation.length == 0) operation = new String[]{"+"};
		// set default values
		int correctAnswers = 0, incorrectAnswers = 0;
		int result = 0, userAnswer = 0, randomNumber;
		// loop for number of questions from first value in questionMdifiers
		for (int i = 0; i < questionModifiers[0]; i++) {
			// generate new random number and add to string and result
			randomNumber = genRandInt(questionModifiers[1], questionModifiers[2]);
			result = randomNumber;
			String questionString = randomNumber + " ";
			// loop for any number of operation there is
			for (String string : operation) {
				// generate every other number based on how many is needed
				randomNumber = genRandInt(questionModifiers[1], questionModifiers[2]);
				// depending on what current operation is calculate result and update string
				switch (string) {
					case "+":
						result += randomNumber;
						questionString += "+ " + randomNumber + " ";
						break;
					case "-":
						result -= randomNumber;
						questionString += "- " + randomNumber + " ";
						break;
					default:
						break;
				}
			}
			// at the end add equal sighn
			System.out.print(questionString + "= ");
			// try to get user answer
			while (true) {
				try {
					userAnswer = Zadatak_05.readFromConsole(userAnswer);
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage() + "\nTry again to answer question: ");
					
				}
			}
			// update answer counters
			if (result == userAnswer) correctAnswers++;
			else incorrectAnswers++;
		}
		// print congration message if all correct or status if few are incorrect
		if (incorrectAnswers == 0) System.out.println("You answered all correctly!");
		else System.out.printf("You answered %d correct and %d incorrect.", correctAnswers, incorrectAnswers);
		
		// 1 + 2 =
		// 1 |+ 2 |=
		// 1 |+ 2 |+ 2 |=
	}
	public static void main(String[] args) throws Exception{
		int numberOfQuestions = 0;
		while (true) {
			try {
				System.out.print("Enter number of questions: ");
				numberOfQuestions = Zadatak_05.readFromConsole(numberOfQuestions);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\nTry again...");
				
			}
		}
//		System.out.println(numberOfQuestions);
		askSimpleQuestion(new int[]{numberOfQuestions, 1, 9}, new String[]{"-"});
	}
}
