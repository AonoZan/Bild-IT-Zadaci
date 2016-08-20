
package zadaci_20_08_2016;

import java.util.Date;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Program creates new account using class Account,
	 * sets same values and prints balance, interest rate and date.
	 * @param args
	 */
	public static void main(String[] args) {
		// create account and set interest rate
		Account newAcc = new Account(1122, 20000);
		Account.setAnnualInterestRate(4.5);
		// withdraw some money and deposit some more
		newAcc.withdraw(2500);
		newAcc.deposit(3000);
		// print stats
		System.out.println("Balance: " + newAcc.getBalance());
		System.out.println("Monthly interest: " + newAcc.getMonthlyInterest());
		System.out.println("Date: " + newAcc.getDate());
	}
}
/**
 * Class contains data of bank account.
 * Use withdraw and deposit methods to store and take money fromaccount.
 * @author AonoZan
 *
 */
class Account {
	// variables for id and balance
	private int id = 0;
	private double balance;
	// annual interest rate is same for all accounts
	private static double  annualInterestRate = 0;
	// date is created only once and when object is constructed
	private Date date = new Date();
	// no argument constructor creates defauld account
	Account() {
		this(0, 0);
	}
	// account that sets id and balance
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public static void setAnnualInterestRate(double annualInterestRate) {
		Account.annualInterestRate = annualInterestRate;
	}
	public Date getDate() {
		return date;
	}
	public double getMonthlyInterestRate() {
		return Account.annualInterestRate / 12;
	}
	public double getMonthlyInterest() {
		return this.balance * (getMonthlyInterestRate() / 100);
	}
	// withdraw money from account
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	// deposit money
	public void deposit(double amount) {
		this.balance += amount;
	}
}
