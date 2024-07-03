package com.geek;

import com.geek.Book.BookMapper;
import com.geek.Book.BookRepository;
import com.geek.Book.BookService;
import com.geek.Book.BookUI;
import static com.geek.Utils.Helpers.readInt;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        BookMapper bookMapper = new BookMapper();
        BookRepository bookRepository = new BookRepository(bookMapper);
        BookUI bookUI = new BookUI(scanner);
        BookService bookService = new BookService(bookRepository, bookMapper, bookUI);

        while(true){
           int option = readInt("please to enter you choice ", scanner);
           switch(option){
               case 1 -> bookService.save();
               case 2 -> bookService.update();
               case 3 -> bookService.delete();
               case 4 -> bookService.fetchAll();
               default -> System.out.println("please enter a valid option");
           }
        }


    }
}