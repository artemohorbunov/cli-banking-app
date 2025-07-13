import java.util.ArrayList;
import java.util.Scanner;

/**
 * Name: Artem Horbunov Date: 6/27/25 File: SavingsAccountRunner.java
 * Description: A simple banking application that creates a new user using
 * constructors. A user can deposit, view monthly interest rate and account
 * details. Those are achieved by using accessors and mutators to change
 * instance variables of a class.
 */

public class SavingsAccountRunner {

	public static void main(String[] args) {
		SavingsAccount savingsAccount1 = new SavingsAccount(); // Create an object using a blueprint class
		// Declare variables
		int option = 0; // Which menu option user picks (1-4)
		boolean inMenu = true; // Is user still in menu
		boolean showMenu = true; // Keeps track if a user entered a wrong option and doesn't show menu

		Scanner input = new Scanner(System.in); // Get user input using setters and getters instance methods
		System.out.print("Welcome to your Savings Account App!\nEnter your account nickname: ");
		savingsAccount1.setId(input.nextLine());
		System.out.print("Enter your initial balance: ");
		savingsAccount1.setBalance(input.nextDouble());
		System.out.print("Enter your annual interest rate: ");
		savingsAccount1.setAnnualInterestRate(input.nextDouble());

		do {
			if (showMenu) { // Unless wrong input entered later on in switch show menu
				System.out.println("=============================");
				System.out.println("=       OPTIONS BELOW       =");
				System.out.println("=============================");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. View Transaction History");
				System.out.println("4. View Account Details");
				System.out.println("5. Exit");
				System.out.print("Enter your selection: ");
			}
			option = input.nextInt(); // Get user input for menu
			showMenu = true; // Show menu after a right input was entered
			switch (option) {
			case 1:
				handleDeposit(input, savingsAccount1);
				break;
			case 2:
				if (savingsAccount1.getBalance() == 0) {
					System.out.println("\nYou have no funds available to withdraw, deposit some money.\n");
					break;
				}
				handleWithdraw(input, savingsAccount1);
				break;
			case 3:
				System.out.println("\nYour transaction history: ");
				System.out.printf("%-35s%-15s%-15s%-15s%n", "Date", "Type", "Amount", "Balance");
				ArrayList<Transaction> transactions = savingsAccount1.getTransactions();
				for (int i = 0; i < transactions.size(); i++) {
					Transaction t = (Transaction) transactions.get(i);
					System.out.printf("%-35s%-15s$%-14.2f$%-14.2f%n%n", t.getTimestamp(), t.getType(), t.getAmount(), t.getBalanceAfter());

				}
				break;
			case 4:
				System.out.println("\nAccount Nickname: " + savingsAccount1.getId());
				System.out.println("Account Creation Date/Time: " + savingsAccount1.getDateEstablished());
				System.out.printf("Balance: $%.2f%n", savingsAccount1.getBalance());
				System.out.printf("Monthly Interest Amount: $%.2f%n%n", savingsAccount1.getMonthlyInterestAmount());

				break;
			case 5:
				inMenu = false; // Keep the loop going until user exits by choosing option 5
				System.out.println("\nThank you - Goodbye!");
				break;

			default:
				System.out.print("INVALID SELECTION - TRY AGAIN: ");
				showMenu = false; // Don't show menu after wrong input
				break;
			}
		} while (inMenu); // Keep the loop going until user exits by choosing option 4

		input.close(); // Close scanner to eliminate resource leaks.
	}

	public static void handleDeposit(Scanner input, SavingsAccount account) {
		boolean isValid = true;
		do {
			System.out.print("Enter your deposit amount: ");
			double depositAmount = input.nextDouble();
			try { // Deposit money if user input > 0
				account.deposit(depositAmount);
				System.out.printf("\nNew Balance: $%.2f%n%n", account.getBalance());
				isValid = false;
			} catch (IllegalArgumentException e) { // Do not deposit negative amount
				System.out.println(e.getMessage());
			}
		} while (isValid); // Until user inputs a positive amount keep asking to re enter
	}

	public static void handleWithdraw(Scanner input, SavingsAccount account) {
		boolean isValid = true;
		do {
			System.out.print("Enter an amount you would like to withdraw: ");
			double withdrawAmount = input.nextDouble();
			try { // Withdraw money if input is valid
				account.withdraw(withdrawAmount);
				System.out.printf("\nNew Balance: $%.2f%n%n", account.getBalance());
				isValid = false;
			} catch (IllegalArgumentException e) { // Cannot withdraw negative amount
				System.out.println(e.getMessage());
			}
		} while (isValid); // Until user inputs a positive amount keep asking to re enter
	}

}
