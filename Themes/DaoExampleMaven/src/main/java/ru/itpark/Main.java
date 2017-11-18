package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Main {

  private static final String URL = "jdbc:postgresql://localhost:5432/sidikov_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Zaq12wsx";

  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);

    UsersDao usersDao = new UsersDaoJdbcTemplateImpl(dataSource);

    HumanService service = new HumanService(usersDao);

    List<User> users = usersDao.findAll();

    int i = 0;

  }
}
