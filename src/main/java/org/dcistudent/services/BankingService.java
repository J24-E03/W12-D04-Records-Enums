package org.dcistudent.services;

import org.dcistudent.models.BankAccount;
import org.dcistudent.models.enums.AccountType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankingService {
    private Map<String, BankAccount> accounts;

    public BankingService() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createSilverAccount() {
        return this.createAccount(AccountType.SILVER);
    }

    public BankAccount createGoldAccount() {
        return this.createAccount(AccountType.GOLD);
    }

    public BankAccount createPlatinumAccount() {
        return this.createAccount(AccountType.PLATINUM);
    }

    private BankAccount createAccount(AccountType accountType) {
        String accountNumber = UUID.randomUUID().toString();
        BankAccount account = new BankAccount();
        account.setAccountNumber(accountNumber);
        account.setAccountType(accountType);
        account.setBalance(0.0);
        this.accounts.put(accountNumber, account);

        return account;
    }

    public BankAccount getAccount(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, Double amount) {
        BankAccount fromAccount = this.accounts.get(fromAccountNumber);
        BankAccount toAccount = this.accounts.get(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        System.out.println("Transferred " + amount + " from " + fromAccountNumber + " to " + toAccountNumber + ".");
    }
}
