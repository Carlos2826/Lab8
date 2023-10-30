package com.example.ejemplo.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  public Connection openDb() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mariadb://localhost:3306/chichemes", "root", "messi");
    } catch (SQLException e) {
      System.out.println("ERROR");
      int x = 1;
    } catch (ClassNotFoundException cnfex) {
      System.out.println("ERROR");
      int x = 1;
    }
    return null;
  }
}