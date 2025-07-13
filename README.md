---

# CLI Banking App 💰

A simple command-line banking application written in Java that simulates a savings account system. Users can create an account, deposit and withdraw funds, and view interest rates and account details via a clean terminal interface.

---

## 🚀 Features

* ✅ Create a savings account with nickname, balance, and interest rate
* ✅ Deposit funds with input validation
* ✅ Withdraw funds with overdraft protection
* ✅ Calculate and display monthly interest
* ✅ View full account details with creation timestamp
* ✅ Built using object-oriented principles (constructors, encapsulation, accessors/mutators)
* ✅ Terminal-based user interface with clear prompts and error handling

---

## 🛠 Technologies Used

* **Java (JDK 24)**
* **CLI / Terminal (Linux-native development)**
* **Object-Oriented Programming (OOP)**
* **Exception Handling**
* **Modular Code Design (separation of concerns)**

---

## 📁 Project Structure

```
cli-banking-app/
├── SavingsAccount.java          # Class representing the bank account
├── SavingsAccountRunner.java    # Main class with CLI interface
├── LICENSE                      # MIT License
└── README.md                    # Project documentation
```

---

## 🧪 How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/artemohorbunov/cli-banking-app.git
   cd cli-banking-app
   ```

2. Compile the Java files:

   ```bash
   javac SavingsAccount.java SavingsAccountRunner.java
   ```

3. Run the app:

   ```bash
   java SavingsAccountRunner
   ```

---

## 🧠 What I Learned

* Implemented real-world banking logic using Java
* Designed user input validation using `IllegalArgumentException`
* Wrote clean, maintainable CLI logic using helper methods
* Practiced defensive programming and graceful failure handling
* Reinforced principles of encapsulation and method abstraction

---

## 📌 Sample Screenshot

```text
Welcome to your Savings Account App!
Enter your account nickname: Art
Enter your initial balance: 100
Enter your annual interest rate: 3.5

=============================
=       OPTIONS BELOW       =
=============================
1. Deposit
2. Withdraw
3. View Monthly Interest Rate
4. View Account Details
5. Exit
Enter your selection:
```

---

## ✅ Future Enhancements

* [ ] Add support for multiple accounts
* [ ] Save/load data to/from a local file (persistence)
* [ ] Add transaction history tracking
* [ ] Implement a simple login system

---

## 🧑‍💻 Author

**Artem Horbunov**
Aspiring backend Java developer & Linux enthusiast
[GitHub Profile](https://github.com/artemohorbunov)

---

## 📜 License

This project is open-source and free to use under the [MIT License](LICENSE).

---
