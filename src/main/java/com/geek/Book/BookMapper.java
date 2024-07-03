package com.geek.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {

     public PreparedStatement prepareStatement(Book book, PreparedStatement statement) throws SQLException {
          statement.setLong(1, book.isbn());
          statement.setString(2, book.title());
          statement.setString(3, book.author());
          return statement;
     }

     public Book toObject(ResultSet resultSet) throws SQLException {
          return new Book(resultSet.getLong(1), resultSet.getLong(4), resultSet.getString(2), resultSet.getString(3));
     }
}
