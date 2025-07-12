import java.util.Date;

public class SavingsAccount {
	// Declare instance variables
	private String id;
	private double balance = 0;
	private double annualInterestRate;
	private Date dateEstablished = new Date();

	public SavingsAccount() { // No-arg constructor

	}

	public SavingsAccount(String id, double balance) { // Constructor to create user accounts
		this.setId(id); // The "this" refers to the data fields (instance variables)
		this.setBalance(balance);
	}

	public void deposit(double amount) {
		balance += amount; // Add money to a balance
	}

	public double getMonthlyIntRate() { // Calculate interest rate
		double monthlyInterestRate = (annualInterestRate / 100) / 12;
		return balance * monthlyInterestRate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateEstablished() {
		return dateEstablished;
	}

	@Override
	public String toString() { // toString method that will print the contents of the object and override
								// default toString().
		return "Account Details:\n" + "=============================\n" + "Nickname (ID): " + id + "\n"
				+ String.format("Balance: $%.2f\n", balance)
				+ String.format("Annual Interest Rate: %.2f%%\n", annualInterestRate) + "Date Established: "
				+ dateEstablished.toString();
	}

}
