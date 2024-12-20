package org.example;

import java.time.LocalDate;

public record Author(String name, int birthYear, String nationality) {

    public Author {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }

        if (birthYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Birth year cannot be in the future.");
        }

        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality cannot be blank.");
        }
    }

}
