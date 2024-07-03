package com.geek.Book;

import java.util.List;
import java.util.Scanner;

import static com.geek.Utils.Helpers.*;

public class BookUI {
    private final Scanner scanner;

    public BookUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public Book create() {
        log("Please to enter the book information's !");
        Long isbn = readLong("Book Isbn", scanner);
        String title = readString("Book Title", scanner);
        String author = readString("Author", scanner);
        return new Book(0L, isbn, title, author);
    }

    public Book editRequest() {
        log("UPDATE OPERATION!");
        Long id = readLong("Please to enter Book ID ", scanner);
        Long isbn = readLong("Book Isbn", scanner);
        String title = readString("Book Title", scanner);
        String author = readString("Author", scanner);
        return new Book(id, isbn, title, author);
    }

    public Long deleteRequest() {
        log("DELETE OPERATION!");
        return readLong("Please to enter Book ID to delete", scanner);
    }

    public void deleteResponse() {
        log("THE BOOK DELETED SUCCESSFULLY!");
    }

    public void displayBooksList(List<Book> books) {
        log("AVAILABLE BOOKS LIST:");
        for (Book book : books) {
            log("-------------------------------------------------------------");
            log("Book Number : " + book.id());
            log("Book Title => " + book.title());
            log("Book Author => " + book.author());
            log("Book ISBN => " + book.isbn());
            log("-------------------------------------------------------------");
        }
    }
}
