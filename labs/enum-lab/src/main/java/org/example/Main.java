package org.example;

import java.util.concurrent.ExecutionException;

public class Main {
    private static BankingSystem bankingSystem;
    public static void main(String[] args) {
        bankingSystem = BankingSystem.getInstance();

        // enum operations
        System.out.println("\nAccount Types and Limits:");
        for (AccountType type : AccountType.values()) {
            System.out.println(type + " - Withdraw Limit: $" + type.getWithdrawLimit()
                    + ", Deposit Limit: $" + type.getDepositLimit());
        }

        // creating accounts
        bankingSystem.createAccount("ACC1001", AccountType.SILVER, 500);
        bankingSystem.createAccount("ACC1002", AccountType.GOLD, 8000);
        bankingSystem.createAccount("ACC1003", AccountType.PLATINUM, 25000);

        System.out.println("\nAccounts:");
        System.out.printf("First Account: %s%n", bankingSystem.getAccount("ACC1001"));
        System.out.printf("Second Account: %s%n", bankingSystem.getAccount("ACC1002"));
        System.out.printf("Third Account: %s%n", bankingSystem.getAccount("ACC1003"));


        // test deposit
        System.out.println("\nTest Deposit:");
        try {
            BankAccount account = bankingSystem.getAccount("ACC1001");
            System.out.printf("Try to deposit some amounts for account : %s with deposit limit of : %.2f$:%n", account.getAccountNumber(), account.getAccountType().getDepositLimit());
            System.out.println("Deposit 1000$:");
            account.deposit(1000);
            System.out.println("Deposit successful");
            System.out.println("Deposit 2000$:");
            account.deposit(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit error: " + e.getMessage());
        }


        // test withdrawal
        System.out.println("\nTest Withdrawal:");
        try {
            BankAccount account = bankingSystem.getAccount("ACC1002");
            System.out.printf("Try to withdraw some amounts for account : %s with withdraw limit of : %.2f$:%n", account.getAccountNumber(), account.getAccountType().getWithdrawLimit());
            System.out.println("Withdraw 5000$:");
            account.withdraw(5000);
            System.out.println("Withdraw successful");
            System.out.println("Withdraw 15000$:");
            account.withdraw(15000);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
        }

        // test transfer
        System.out.println("\nTest Transfer:");
        try {
            System.out.println("Transfer 500$ from ACC1003 to ACC1001:");
            bankingSystem.transferFunds("ACC1003", "ACC1001", 500);
            System.out.println("Transfer successful:");
            System.out.println("ACC1003 balance: " + bankingSystem.getAccount("ACC1003").getBalance());
            System.out.println("ACC1001 balance: " + bankingSystem.getAccount("ACC1001").getBalance());

            System.out.println("Attempt to transfer 31000$ from ACC1003 to ACC1001:");
            bankingSystem.transferFunds("ACC1003", "ACC1001", 31000);
        } catch (IllegalArgumentException e) {
            System.out.println("Transfer error: " + e.getMessage());
        }

        // test transaction history
        try {
            BankAccount account = bankingSystem.getAccount("ACC1001");
            System.out.println("\nAll transactions for Account: " + account.getAccountNumber());
            bankingSystem.viewAccountTransactions(account.getAccountNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // test closing an account
        try {
            BankAccount account = bankingSystem.getAccount("ACC1002");
            System.out.println("\nClosing Account: " + account.getAccountNumber());
            bankingSystem.closeAccount(account.getAccountNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}