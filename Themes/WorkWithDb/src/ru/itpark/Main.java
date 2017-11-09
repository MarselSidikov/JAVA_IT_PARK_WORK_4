package ru.itpark;

import java.sql.*;
import java.util.Scanner;

public class Main {

  private static final String URL = "jdbc:postgresql://localhost:5432/sidikov_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Zaq12wsx";

  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("SELECT * FROM owner");

      while (resultSet.next()) {
        System.out.print(resultSet.getInt("id") + " ");
        System.out.print(resultSet.getString("name") + " ");
        System.out.print(resultSet.getInt("age") + " ");
        System.out.print(resultSet.getString("citizen"));
        System.out.println();
      }

      Scanner scanner = new Scanner(System.in);

      String name = scanner.next();
      int age = scanner.nextInt();
      String citizen = scanner.next();

//      statement.executeUpdate("INSERT INTO owner(age, name, citizen) VALUES (" +
//        age + ", '" + name + "', '" + citizen + "');" );

      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO owner(age, name, citizen) " +
          "VALUES(?, ?, ?)");

      preparedStatement.setInt(1, age);
      preparedStatement.setString(2, name);
      preparedStatement.setString(3, citizen);

      preparedStatement.execute();

    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }

  }
}
