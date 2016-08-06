/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_01 {
	/**
	 * Method calculates amount of savings from monthly rate, amount of savings each month and number of month.
	 * @param monthlyRate Percentage of monthly interest rate.
	 * @param amountOfMoney Amount of money that will be saved.
	 * @param numberOfMonths Number of months.
	 * @return Returns 0 if any of the arguments is 0 or negative. Returns amount of money after certain number of months.
	 */
	public static double calculateAccountSavings(double monthlyRate, double amountOfMoney, int numberOfMonths) {
		// check if arguments are of correct values
		if (monthlyRate <= 0) {
			System.out.println("Can't calculate savings. Monthly rate zero or negative.");
			return 0;
		} else if (amountOfMoney <= 0) {
			System.out.println("Can't calculate savings. Amount of money zero or negative.");
			return 0;
		} else if (numberOfMonths <= 0) {
			System.out.println("Can't calculate savings. Number of months zero or negative.");
			return 0;
		}
		// calculate amount of money after given number of months and return that value
		double monthlySavings = amountOfMoney;
		amountOfMoney = 0;
		for (int i = 1; i <= numberOfMonths; i++) {
			amountOfMoney = (monthlySavings + amountOfMoney) * (1 + monthlyRate);
		}
		return amountOfMoney;
	}
	/**
	 * Program asks user amount of money he/she wants to save each month and for how many months.
	 * If user enters wrong value program asks user to enter correct one.
	 * When user enters values program calculates how much money user will save after given number of months.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables and ask user for values
		double monthlySavings = 0;
		int timeInMonths = 0;
		while(true) {
			try {
				// if still defauls value for savings try to get correct one and check if it's not zero or negative
				if (monthlySavings == 0) {
					System.out.print("Enter amount of money you will save every month: ");
					monthlySavings = zadaci_03_08_2016.Zadatak_02.readFromConsole(monthlySavings);
					// if user enters wrong value for money politely exit
					if (monthlySavings == 0) {
						System.out.println("If you don't save money, no treats for you. :)");
						System.exit(0);
					} else if (monthlySavings < 0) {
						System.out.println("You cant save negative amount of money. Doesn't make sense.");
						System.exit(0);
					}
				}
				// if default value for time try to get correct one
				if (timeInMonths == 0) {
					System.out.print("Enter value for time(months): ");
					timeInMonths = zadaci_01_08_2016.Zadatak_05.readFromConsole(timeInMonths);
					// if user enters incorrect one print message and raise exception
					if (timeInMonths <= 0) {
						System.out.printf("Value for time can't be %d.\n", timeInMonths);
						timeInMonths = 0;
						throw new Exception("Enter correct value.");
					}
				}
				// if both variable have correct values break out of loop
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// calculate amount of money after given number of months and print it to console
		double amountOfMoneyAfter = calculateAccountSavings((0.05 / 12), monthlySavings, timeInMonths);
		System.out.printf("You will have %.2f on account after %d month%s.",
				amountOfMoneyAfter, timeInMonths, timeInMonths > 1 ? "'s" : "");
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
