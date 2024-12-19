package org.example;

public enum AccountType {
    SILVER(1000, 1500),
    GOLD(10000, 15000),
    PLATINUM(20000, 30000);

    private final double WITHDRAW_LIMIT;
    private final double DEPOSIT_LIMIT;

    AccountType(double withdrawLimit, double depositLimit) {
        this.WITHDRAW_LIMIT = withdrawLimit;
        this.DEPOSIT_LIMIT = depositLimit;
    }

    public double getWithdrawLimit() {
        return WITHDRAW_LIMIT;
    }

    public double getDepositLimit() {
        return DEPOSIT_LIMIT;
    }
}
