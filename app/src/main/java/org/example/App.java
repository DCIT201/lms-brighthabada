/*
 * This should be your main class where all your objects will be created
 */
package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();

                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter the ISBN of the book to check out: ");
                    String checkOutIsbn = scanner.nextLine();
                    Book bookToCheckOut = library.findBookByIsbn(checkOutIsbn);

                    if (bookToCheckOut != null) {
                        library.checkOutBook(bookToCheckOut);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    Book bookToReturn = library.findBookByIsbn(returnIsbn);

                    if (bookToReturn != null) {
                        library.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
