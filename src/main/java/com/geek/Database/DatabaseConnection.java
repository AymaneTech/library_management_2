package com.geek.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

     private static DatabaseConnection instance = null;
     private Connection connection = null;

     private DatabaseConnection() throws SQLException {
          String url = "jdbc:postgresql://localhost:5432/middle_night";
          String username = "postgres";
          String password = "admin";
          try {
               connection = DriverManager.getConnection(url, username, password);
          } catch (SQLException e) {
               throw new SQLException(e);
          }
     }

     public static DatabaseConnection getInstance() throws SQLException {
          if (instance == null || !instance.connection.isClosed()) {
               instance = new DatabaseConnection();
          }
          return instance;
     }

     public static boolean closeConnection() {
          if (instance != null) {
               try {
                    instance.getConnection().close();
                    instance = null;
                    return true;
               } catch (SQLException e) {
                    throw new RuntimeException(e);
               }
          }
          return false;
     }

     public Connection getConnection() {
          return connection;
     }

}
