package org.example;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Jane Austen", 1775, "British");
        Author author2 = new Author("Mark Twain", 1835, "American");
        Author author3 = new Author("Mark Twain", 1835, "American");

        System.out.println("My Authors:");

        System.out.printf("First Author = %s%n", author1);
        System.out.printf("Second Author = %s%n", author2);
        System.out.printf("Third Author = %s%n", author3);

        System.out.printf("%nAre the first two authors equal? %b%n", author1.equals(author2));
        System.out.printf("Hashcode of Author1 = %d%n", author1.hashCode());
        System.out.printf("Hashcode of Author2 = %d%n", author2.hashCode());

        System.out.printf("%nAre the last two authors equal? %b%n", author2.equals(author3));
        System.out.printf("Hashcode of Author2 = %d%n", author2.hashCode());
        System.out.printf("Hashcode of Author3 = %d%n", author3.hashCode());


        Book book1 = new Book("Pride and Prejudice", author1, 19.99, 1813);
        Book book2 = new Book("Adventures of Huckleberry Finn", author2, 14.99, 1884);
        Book book3 = new Book("Tom Sawyer", author2, 14.99, 1876);

        System.out.println("\nMy Books:");
        System.out.printf("Book 1 = %s%n", book1);
        System.out.printf("Book 2: = %s%n", book2);
        System.out.printf("Book 3 = %s%n", book3);

        System.out.printf("%nAre Book 1 and Book 2 equal? %b%n",  book1.equals(book2));

        System.out.printf("%nBetween \"%s\" and \"%s\":%n", book1.title(), book2.title());
        Book expensiveBook = Book.compareBooksByPrice(book1, book2);
        if (expensiveBook != null) {
            System.out.printf("The more expensive book is %s with the price: %.2f$.%n", expensiveBook.title(), expensiveBook.price());
        } else {
            System.out.println("Both books have the same price.");
        }

        System.out.println("\nBooks on Sales:");
        showBooksOnsale(10, book1);
        showBooksOnsale(0.3, book3);
    }

    public static void showBooksOnsale(double percentage, Book book) {
        if (percentage < 1.0 && percentage > 0) {
            percentage *= 100;
        }
        System.out.printf("Price of \"%s\" after %.0f%% discount: %.2f%n", book.title()
                , percentage, book.discountedPrice(percentage));
    }
}