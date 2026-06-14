package org.example.banking_account;

public class BankingAccount {

    private String ownerFullName;
    private String accountNumber;
    private double balance;

    public BankingAccount(String ownerFullName, String accountNumber, double balance) {
        this.ownerFullName = ownerFullName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Only positive amount acceptable.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("Account Holder: " + ownerFullName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: %.2f%n", balance);
    }
}
