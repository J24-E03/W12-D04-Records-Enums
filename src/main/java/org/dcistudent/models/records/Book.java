package org.dcistudent.models.records;

import lombok.NonNull;

@NonNull
public record Book(String title, Author author, Double price, Integer publicationYear) {
    public Book {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (publicationYear < 0) {
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }
    }

    public Double discountedPrice(Double discount) {
        return this.price - (this.price * discount);
    }

    /**
     * This method should compare two Book instances and return the book with the higher price.
     */
    public static String compareByPrice(Book book1, Book book2) {
        if (book1.price.compareTo(book2.price) > 0) {
            return book1.title();
        }
        if (book1.price.compareTo(book2.price) < 0) {
            return book2.title();
        }

        return "[Equal]";
    }
}
