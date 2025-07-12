import java.util.Scanner;

/**
 * Name: Artem Horbunov 
 * Date: 6/27/25 
 * File: SavingsAccountRunner.java
 * Description: A simple banking application that creates a new user using 
 * constructors. A user can deposit, view monthly interest rate and account details. 
 * Those are achieved by using accessors and mutators to change instance variables of a class.
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
				System.out.println("=============================\n" + "=       OPTIONS BELOW       =	    \n"
						+ "=============================\n" + "1. Deposit\n" + "2. View Monthly Interest Rate\n"
						+ "3. View Account Details\n" + "4. Exit\n" + "Enter your selection");
			}
			option = input.nextInt(); // Get user input for menu
			showMenu = true; // Show menu after a right input was entered
			switch (option) {
			case 1:
				boolean negativeAmount = false;
				do {
					System.out.println("Enter your deposit amount: ");
					double depositAmount = input.nextDouble();
					if (depositAmount > 0) { // Deposit money if user input > 0
						savingsAccount1.deposit(depositAmount);
						negativeAmount = false;
						System.out.printf("New Balance: $%.2f%n", savingsAccount1.getBalance());
					} else { // Do not deposit negative amount
						negativeAmount = true;
						System.out.println("You entered a negative amount. Try again");
					}
				} while (negativeAmount); // Until user inputs a positive amount keep asking to re enter
				break;
			case 2:
				System.out.printf("Monthly Interest Amount: $%.2f%n", savingsAccount1.getMonthlyIntRate());
				break;
			case 3:
				System.out.println("Account Nickname: " + savingsAccount1.getId());
				System.out.println("Account Creation Date/Time: " + savingsAccount1.getDateEstablished());
				System.out.printf("Balance: $%.2f%n", savingsAccount1.getBalance());
				System.out.printf("Monthly Interest Amount: $%.2f%n", savingsAccount1.getMonthlyIntRate());

				break;
			case 4:
				inMenu = false; // Break out of the main program loop
				System.out.println("Thank you - Goodbye!");
				break;

			default:
				System.out.println("INVALID SELECTION - TRY AGAIN!");
				showMenu = false; // Don't show menu after wrong input
				break;
			}
		} while (inMenu); // Keep the loop going until user exits by choosing option 4
		
		input.close(); // Close scanner to eliminate resource leaks.
	}

}
