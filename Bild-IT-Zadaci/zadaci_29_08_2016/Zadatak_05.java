
package zadaci_29_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**Program tests new loan class that can throw illegal argument expression.*/
	public static void main(String[] args) {
		Loan loan;
		System.out.println("Try to create loan object with one argument as 0.");
		try {
			// try to create loan
			loan = new Loan(0 , 1, 100);
			System.out.println(loan.getAnnualInterestRate());
		} catch (IllegalArgumentException e) {
			// exception is raised
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error. Exit.");
		}
	}

}

class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() {
		this(2.5, 1, 1000);
	}

	/**
	 * Construct a loan with specified annual interest rate, number of years,
	 * and loan amount
	 */
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		// check arguments
		legalArgument(annualInterestRate);
		legalArgument(numberOfYears);
		legalArgument(loanAmount);
		
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}
	/** Check if valid argument.*/
	private void legalArgument(double arg) {
		if (arg <= 0) {
			// throw exception if <=0
			throw new IllegalArgumentException("Argument in class loan can't be 0 or less.");
		}
	}
	
	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a new loanAmount */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate
				/ (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}

	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}