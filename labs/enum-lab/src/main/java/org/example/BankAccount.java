package org.example;

public class BankAccount {
    private String accountNumber;
    private AccountType accountType;
    private double balance;

    public BankAccount(String accountNumber, AccountType accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > accountType.getDepositLimit()) {
            throw new IllegalArgumentException("Amount exceeds the deposit limit.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > accountType.getWithdrawLimit()) {
            throw new IllegalArgumentException("Amount exceeds the withdraw limit.");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}