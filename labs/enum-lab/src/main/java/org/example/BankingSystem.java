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
        BankAccount sender = getAccount(fromAccountNumber);
        BankAccount receiver = getAccount(toAccountNumber);

        if (amount > sender.getAccountType().getWithdrawLimit()) {
            throw new IllegalArgumentException("Amount exceeds the withdraw limit of sender account.");
        }
        if (sender.getBalance() < amount) {
            throw new IllegalArgumentException("Sender account has insufficient balance.");
        }
        if (amount > receiver.getAccountType().getDepositLimit()) {
            throw new IllegalArgumentException("Amount exceeds the deposit limit of receiver account.");
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
    }
}
