package org.dcistudent;

import org.dcistudent.models.BankAccount;
import org.dcistudent.models.enums.AccountType;
import org.dcistudent.services.BankingService;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        BankingService service = new BankingService();
        BankAccount account1 = service.createSilverAccount();
        BankAccount account2 = service.createGoldAccount();
        BankAccount account3 = service.createPlatinumAccount();

        System.out.println("Account type and their limits:");
        for (AccountType accountType : AccountType.values()) {
            System.out.println(accountType + " " + accountType.getDepositLimit() + " " + accountType.getWithdrawalLimit());
        }

        System.out.println("\n================================================================================\n");

        account1.deposit(500.0);
        account2.deposit(1000.0);
        account3.deposit(2000.0);

        account1.withdraw(100.0);
        account2.withdraw(200.0);
        account3.withdraw(300.0);

        System.out.println("Account 1: " + account1.getAccountNumber() + " " + account1.getAccountType() + " " + account1.getBalance());
        System.out.println("Account 2: " + account2.getAccountNumber() + " " + account2.getAccountType() + " " + account2.getBalance());
        System.out.println("Account 3: " + account3.getAccountNumber() + " " + account3.getAccountType() + " " + account3.getBalance());

        System.out.println("\n================================================================================\n");

        try {
            account1.deposit(1001.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account2.withdraw(1501.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n================================================================================\n");

        service.transferFunds(account1.getAccountNumber(), account2.getAccountNumber(), 100.0);
        service.transferFunds(account2.getAccountNumber(), account3.getAccountNumber(), 200.0);
        service.transferFunds(account3.getAccountNumber(), account1.getAccountNumber(), 300.0);

        System.out.println("Account 1: " + account1.getAccountNumber() + " " + account1.getAccountType() + " " + account1.getBalance());
        System.out.println("Account 2: " + account2.getAccountNumber() + " " + account2.getAccountType() + " " + account2.getBalance());
        System.out.println("Account 3: " + account3.getAccountNumber() + " " + account3.getAccountType() + " " + account3.getBalance());
    }
}
