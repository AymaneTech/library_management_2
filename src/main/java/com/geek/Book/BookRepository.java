package com.geek.Book;

import com.geek.Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
  private final Connection connection;
  private final BookMapper bookMapper;

  public BookRepository(BookMapper bookMapper) throws SQLException {
    this.bookMapper = bookMapper;
    this.connection = DatabaseConnection.getInstance().getConnection();
  }

  public List<Book> fetchAll() {
    List<Book> books = new ArrayList<>();
    String query = "SELECT * FROM books";

    try {
      PreparedStatement statement = connection.prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Book book = bookMapper.toObject(resultSet);
        books.add(book);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return books;
  }

  public Book save(Book book) throws SQLException {
    String query = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";
    try (PreparedStatement statement = bookMapper.prepareStatement(
             book, connection.prepareStatement(query))) {
      isRowsAffected(statement.executeUpdate());

    } catch (SQLException e) {
      throw new SQLException(e);
    }
    return book;
  }

  public Book update(Book book) throws SQLException {
    String query =
        "UPDATE books SET isbn = ?, title = ?, author = ? WHERE id = ?";
    try (PreparedStatement statement = bookMapper.prepareStatement(
             book, connection.prepareStatement(query))) {
      statement.setLong(4, book.id());
      isRowsAffected(statement.executeUpdate());

    } catch (SQLException e) {
      throw new SQLException(e);
    }
    return book;
  }

  public void delete(Long id)throws SQLException {
    String query = "DELETE FROM books WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setLong(1, id);
      isRowsAffected(statement.executeUpdate());
    } catch (SQLException e) {
      throw new SQLException(e);
    }
  }

  public Book findByColumnName(String columnName, String value)
      throws SQLException {
    Book book = null;
    String query = "SELECT * FROM books WHERE " + columnName + " = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        book = bookMapper.toObject(resultSet);
      }
    } catch (SQLException e) {
      throw new SQLException(e);
    }
    return book;
  }

  private void isRowsAffected(int affectedRows) throws SQLException {
    if (affectedRows == 0)
      throw new SQLException("Failed to update book");
  }
}
