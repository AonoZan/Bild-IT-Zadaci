/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

public class Zadatak_01 {
	/**
	 * Program asks for yearly interest rate, amount of money for investition and time(in years).
	 * Program then calculates and presents future investment value.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables and ask user for values
		double yearlySavings = 0, yearlyInterestRate = 0;
		int timeInYears = 0;
		while(true) {
			try {
				// if still defauls value for investment rate ask for value
				if (yearlyInterestRate == 0) {
					System.out.print("Enter value for yearly interest rate: ");
					yearlyInterestRate = zadaci_03_08_2016.Zadatak_02.readFromConsole(yearlyInterestRate);
					// if user enters wrong value for investment reset and ask again
					if (yearlySavings < 0) {
						System.out.println("Yearly interest rate cant be negative.");
						yearlyInterestRate = 0;
						throw new Exception("Enter correct value.");
					}
				}
				// if still defauls value for savings try to get correct one and check if it's not zero or negative
				if (yearlySavings == 0) {
					System.out.print("Enter amount of money you will save every year: ");
					yearlySavings = zadaci_03_08_2016.Zadatak_02.readFromConsole(yearlySavings);
					// if user enters wrong value for money politely exit
					if (yearlySavings == 0) {
						System.out.println("If you don't save money, no treats for you. :)");
						System.exit(0);
					} else if (yearlySavings < 0) {
						System.out.println("You cant save negative amount of money. Doesn't make sense.");
						System.exit(0);
					}
				}
				// if default value for time try to get correct one
				if (timeInYears == 0) {
					System.out.print("Enter value for time(years): ");
					timeInYears = zadaci_01_08_2016.Zadatak_05.readFromConsole(timeInYears);
					// if user enters incorrect one print message and raise exception
					if (timeInYears <= 0) {
						System.out.printf("Value for time can't be %d.\n", timeInYears);
						timeInYears = 0;
						throw new Exception("Enter correct value.");
					}
				}
				// if all variable have correct values break out of loop
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// calculate amount of money after given number of years and print it to console
		double monthlyIntrestRate = ((yearlyInterestRate/12f))/100f;
		double amountOfMoneyAfter = yearlySavings * Math.pow((1 + monthlyIntrestRate), timeInYears * 12);
		System.out.printf("Your future investment will be %.2f after %d year%s.",
				amountOfMoneyAfter, timeInYears, timeInYears > 1 ? "'s" : "");
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
