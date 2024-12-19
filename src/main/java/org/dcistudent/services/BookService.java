package org.dcistudent.services;

import org.dcistudent.models.records.Author;
import org.dcistudent.models.records.Book;

public class BookService {
    public BookService() {
        Author author1 = new Author("John Doe", 1986, "Internationalist");
        Author author2 = new Author("Jane Doe", 1988, "Internationalist");
        Author author3 = new Author("Jack Doe", 1990, "Internationalist");

        Book book1 = new Book("Foo", author1, 19.95, 2008);
        Book book2 = new Book("Bar", author2, 29.95, 2010);
        Book book3 = new Book("Baz", author3, 39.95, 2012);

        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3);

        System.out.println("Book 1 equals Book 2: " + book1.equals(book2));
        System.out.println("Book 1 discount: " + String.format("%.2f", book1.discountedPrice(0.10)));
        System.out.println("Book 1 & book 2 price comparison: " + Book.compareByPrice(book1, book2));
    }
}
