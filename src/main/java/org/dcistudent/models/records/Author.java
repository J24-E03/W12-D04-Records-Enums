package org.dcistudent.models.records;

import lombok.NonNull;

@NonNull
public record Author(String name, Integer birthYear, String nationality) {
    public Author {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (birthYear < 0) {
            throw new IllegalArgumentException("Birth year cannot be negative.");
        }
        if (nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality cannot be blank.");
        }
    }
}
