package org.example;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void checkOutBook(Book book) {
        if (book.isAvailable()) {
            book.checkOut();
            System.out.println(book.getTitle() + " has been checked out.");
        } else {
            System.out.println(book.getTitle() + " is already checked out.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(book.getTitle() + " has been returned.");
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
