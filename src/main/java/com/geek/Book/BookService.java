package com.geek.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookUI bookUI;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, BookUI bookUI) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookUI = bookUI;
    }

    public void fetchAll() {
        List<Book> books = bookRepository.fetchAll();
        bookUI.displayBooksList(books);
    }

    public Book save() throws SQLException {
        Book book = bookUI.create();
        return bookRepository.save(book);
    }

    public Book update() throws SQLException {
        Book book = bookUI.editRequest();
        return bookRepository.update(book);
    }

    public void delete() throws SQLException {
        Long id = bookUI.deleteRequest();
        bookRepository.delete(id);
        bookUI.deleteResponse();
    }

}
