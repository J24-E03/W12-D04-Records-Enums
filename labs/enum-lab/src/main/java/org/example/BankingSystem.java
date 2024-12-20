package org.example;

import java.util.HashMap;
import java.util.Map;

public class BankingSystem {
    private static BankingSystem bankingSystemInstance = null;
    private final Map<String, BankAccount> accountMap;

    private BankingSystem() {
        accountMap = new HashMap<>();
    }

    public static BankingSystem getInstance() {
        if (bankingSystemInstance == null) {
            bankingSystemInstance = new BankingSystem();
        }
        return bankingSystemInstance;
    }

    public void createAccount(String accountNumber, AccountType accountType, double initialBalance) {
        BankAccount newBankAccount = new BankAccount(accountNumber, accountType, initialBalance);
        accountMap.put(accountNumber, newBankAccount);
    }

    public BankAccount getAccount(String accountNumber) {
        if (!accountMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account " + accountNumber + " not found.");
        }
        return accountMap.get(accountNumber);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        if (!accountMap.containsKey(fromAccountNumber)) {
            throw new IllegalArgumentException("Sender account is invalid!");
        }

        if (!accountMap.containsKey(toAccountNumber)) {
            throw new IllegalArgumentException("Receiver account is invalid!");
        }

        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        if (amount > fromAccount.getAccountType().getWithdrawLimit()) {
            throw new IllegalArgumentException("The amount exceeds the withdraw limit of the sender account");
        }

        if (amount > fromAccount.getBalance()) {
            throw new IllegalArgumentException("Balance is not enough.");
        }

        if (amount > toAccount.getAccountType().getDepositLimit()) {
            throw new IllegalArgumentException("The amount exceeds the deposit limit of the receiver account");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
    public void closeAccount(String accountNumber) {
        if (!accountMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }
        accountMap.remove(accountNumber);
        System.out.println("Account: " + accountNumber + " was successfully closed.");
    }

    public void viewAccountTransactions(String accountNumber) {
        if (!accountMap.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }
        BankAccount account = accountMap.get(accountNumber);
        System.out.println("Transactions for Account " + accountNumber + ":");
        for (String transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
