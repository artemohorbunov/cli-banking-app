import java.util.Date;
import java.util.ArrayList;

public class SavingsAccount {
	// Declare instance variables
	private String id;
	private double balance = 0;
	private double annualInterestRate;
	private final Date dateEstablished = new Date();
	private ArrayList<Transaction> transactions = new ArrayList();

	public SavingsAccount() { // No-arg constructor

	}

	public SavingsAccount(String id, double balance) { // Constructor to create user accounts
		this.setId(id); // The "this" refers to the data fields (instance variables)
		this.setBalance(balance);
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be greater than 0.");
		}
		balance += amount; // Add money to a balance
		transactions.add(new Transaction('D', amount, balance)); // Register a transaction
	}

	public void withdraw(double amount) {
		if (balance == 0) {
			throw new IllegalArgumentException("You do not have any funds to withdraw.");
		} else if (amount <= 0) {
			throw new IllegalArgumentException("Withdraw amount must be greater than 0.");
		} else if (amount > balance) {
			throw new IllegalArgumentException("Insufficient funds. You only have $" + String.format("%.2f", balance));
		}
		balance -= amount; // Withdraw money from a balance
		transactions.add(new Transaction('W', amount, balance)); // Register a transaction
	}

	public double getMonthlyInterestAmount() { // Calculate interest amount
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
		return new Date(dateEstablished.getTime());
	}

	@Override
	public String toString() { // toString method that will print the contents of the object and override
								// default toString().
		return "Account Details:\n" + "=============================\n" + "Nickname (ID): " + id + "\n"
				+ String.format("Balance: $%.2f\n", balance)
				+ String.format("Annual Interest Rate: %.2f%%\n", annualInterestRate) + "Date Established: "
				+ dateEstablished.toString();
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
}
