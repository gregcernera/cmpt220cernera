import java.util.Date;

public class Problem11_3 {

	// FINISHED
	// (Subclasses of Account)
	// UML
	public static void main(String[] args) {
		
		Account account = new Account(1, 500);
		CheckingAccount checkingAccount = new CheckingAccount(2, 300);
		SavingsAccount savingsAccount = new SavingsAccount(3, 700);
		
		System.out.println(account);
		System.out.println(checkingAccount);
		System.out.println(savingsAccount);

	}

}

class Account {
	private int id;
	private double balance;
	private static double annualInterestRate = 0;
	Date dateCreated;
	
	Account() {
		id = 0;
		balance = 0;
		dateCreated = new Date();
	}
	
	Account(int newId, double newBalance) {
		id = newId;
		balance = newBalance;
		dateCreated = new Date();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id = newId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	public String getDateCreated(){
		return dateCreated.toString();
	}
	
	public void setInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12) / 100;
	}
	
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		return "Account: balance = " + balance;
	}
	
}

class SavingsAccount extends Account {
	
	private double overdraft = 0;
	
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}
	
	@Override
	public void withdraw(double amount) {
		if (super.getBalance() - amount >= overdraft) {
			super.withdraw(amount);
		}
	}
	
	@Override
	public String toString() {
		return "Savings account: balance = " + super.getBalance();
	}
}

class CheckingAccount extends Account {
	
	private double overdraft = -200;
	
	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}
	
	@Override
	public void withdraw(double amount) {
		if (super.getBalance() - amount >= overdraft) {
			super.withdraw(amount);
		}
	}
	
	@Override
	public String toString() {
		return "Checking account: balance = " + super.getBalance();
	}
}

