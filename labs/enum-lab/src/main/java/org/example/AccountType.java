package org.example;

public enum AccountType {
    SILVER(1000, 1500, 0.01),
    GOLD(10000, 15000, 0.03),
    PLATINUM(20000, 30000, 0.05);

    private final double WITHDRAW_LIMIT;
    private final double DEPOSIT_LIMIT;
    private final double INTEREST_RATE;

    AccountType(double withdrawLimit, double depositLimit, double interestRate) {
        this.WITHDRAW_LIMIT = withdrawLimit;
        this.DEPOSIT_LIMIT = depositLimit;
        this.INTEREST_RATE = interestRate;
    }

    public double getWithdrawLimit() {
        return WITHDRAW_LIMIT;
    }

    public double getDepositLimit() {
        return DEPOSIT_LIMIT;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }
}
