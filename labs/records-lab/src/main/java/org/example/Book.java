package org.example;

import java.time.LocalDate;

public record Book(String title, Author author, double price, int publicationYear) {

    public Book {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        if (author == null) {
            throw new IllegalArgumentException("Author cannot be undefined.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than zero.");
        }

        if (publicationYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Publiction year cannot be in the future.");
        }
    }
    public double discountedPrice(double discountPercentage) {
        if (discountPercentage > 1.0) {
            discountPercentage /= 100.0;
        }
        if (discountPercentage < 0 || discountPercentage > 1.0) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        return this.price - (this.price * discountPercentage);
    }

    public static Book compareBooksByPrice(Book book1, Book book2) {
        if (book1.price() > book2.price()) return book1;
        if (book2.price() > book1.price()) return book2;
        return null;
    }
}
