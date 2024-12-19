package org.dcistudent.models;

import lombok.*;
import org.dcistudent.models.enums.AccountType;

@Getter @Setter @NonNull
public class BankAccount {
    private String accountNumber;
    private AccountType accountType;
    private double balance;

    public void deposit(Double amount) {
        if(amount > this.accountType.getDepositLimit()) {
            throw new IllegalArgumentException("Deposit amount exceeds limit.");
        }

        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(Double amount) {
        if(amount > this.accountType.getWithdrawalLimit()) {
            throw new IllegalArgumentException("Withdrawal amount exceeds limit.");
        }

        if(amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        this.setBalance(this.getBalance() - amount);
    }
}
