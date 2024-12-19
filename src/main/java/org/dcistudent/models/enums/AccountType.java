package org.dcistudent.models.enums;

import lombok.*;

@Getter @NonNull
public enum AccountType {
    SILVER(1000.0, 1500.0),
    GOLD(10_000.0, 15_000.0),
    PLATINUM(20_000.0, 30_000.0);

    private final Double depositLimit;
    private final Double withdrawalLimit;

    AccountType(Double depositLimit, Double withdrawalLimit) {
        this.depositLimit = depositLimit;
        this.withdrawalLimit = withdrawalLimit;
    }
}
