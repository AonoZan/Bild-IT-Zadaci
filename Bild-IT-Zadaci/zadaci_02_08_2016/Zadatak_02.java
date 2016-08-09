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
			// @mistake
			/*from = Math.min(from, to);
			to = Math.max(from, to);*/
			to += from;
			from = to - from;
			to -= from;
		}
		// return random value in range
		return from + (int)(Math.random() * (to - from + 1));
	}
	/**
	 * Method for asking simple mathematical questions. Several opearations can be calculated.
	 * @param questionModifiers contains range in which random numbers should be generated
	 * @param operation holds any number of srting values(operations) between numbers, can be any number of "+", "-"
	 * @param forceCorrect if true program will ask same question untill corect answer is entered
	 */
	public static boolean askSimpleQuestion(int[] questionModifiers, String[] operation, boolean forceCorrect) {
		// make sure that at least one question and operation is asked and used 
		if (questionModifiers == null || questionModifiers.length < 2) questionModifiers = new int[]{1, 1, 9};
		if (operation == null || operation.length == 0) operation = new String[]{"+"};
		// set default values
		int result = 0, userAnswer = 0, randomNumber;
		// generate new random number and add to string and result
		randomNumber = genRandInt(questionModifiers[0], questionModifiers[1]);
		result = randomNumber;
		String questionString = randomNumber + " ";
		// loop for any number of operation there is
		for (String string : operation) {
			// generate every other number based on how many is needed
			randomNumber = genRandInt(questionModifiers[0], questionModifiers[1]);
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
			// try to get user answer
			while (true) {
				try {
					// at the end add equal sign
					System.out.print(questionString + "= ");
					userAnswer = Zadatak_05.readFromConsole(userAnswer);
					if (forceCorrect && result != userAnswer)
						throw new Exception("That's not correct answer.");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage() + "\nTry again to answer question. ");
					
				}
			}
		}
		if (result == userAnswer) return true;
		return false;
	}
	/**
	 * Program asks user for one number and using that number asks that many simple mathematical questions.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		// create variables and try to get values from user
		int numberOfQuestions = 0, correctAnswers = 0;
		while (true) {
			try {
				// if variable for questions is still on default get new one
				if (numberOfQuestions == 0) {
					System.out.print("Enter number of questions: ");
					numberOfQuestions = Zadatak_05.readFromConsole(numberOfQuestions);
					// if value is still negative or zero reset it and ask for another one
					if (numberOfQuestions < 1) {
						System.out.printf("%d is not correct value.\n", numberOfQuestions);
						numberOfQuestions = 0;
						throw new Exception("Try again...");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
		// loop for number of questions and count correct ones
		for (int i = 0; i < numberOfQuestions; i++) {
			if (askSimpleQuestion(new int[]{1, 9}, new String[]{"-"}, true)) 
				correctAnswers++;
		}
		// print congration message if all correct or status if few are incorrect
		if (correctAnswers == numberOfQuestions) System.out.println("You answered all correctly!");
		else System.out.printf("You answered %d correct and %d incorrect.", correctAnswers, numberOfQuestions - correctAnswers);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
