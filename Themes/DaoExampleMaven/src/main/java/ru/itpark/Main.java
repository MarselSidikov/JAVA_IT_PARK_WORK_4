package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

    HumansDao humansDao = new HumansDaoJdbcTemplateImpl(dataSource);

    HumanService service = new HumanService(humansDao);

    Human human = Human.builder()
        .age(55)
        .citizen("Америка")
        .name("Авраам")
        .build();

    service.registerUser(human);

  }
}
