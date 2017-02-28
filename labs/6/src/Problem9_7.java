import java.util.Date;

public class Problem9_7 {

	// FINISHED
	// (The Account class)
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		account.setInterestRate(4.5);
		
		account.withdraw(2500);
		account.deposit(3000);
		
		System.out.println("Current balance: " + account.getBalance());
		System.out.println("Monthly interest: " + account.getMonthlyInterest());
		System.out.println("Date Created: " + account.getDateCreated());

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
	
	int getId() {
		return id;
	}
	
	void setId(int newId) {
		id = newId;
	}
	
	double getBalance() {
		return balance;
	}
	
	void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	String getDateCreated(){
		return dateCreated.toString();
	}
	
	void setInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}
	
	double getMonthlyInterestRate() {
		return (annualInterestRate / 12) / 100;
	}
	
	double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	void withdraw(double amount) {
		balance -= amount;
	}
	
	void deposit(double amount) {
		balance += amount;
	}
	
}
