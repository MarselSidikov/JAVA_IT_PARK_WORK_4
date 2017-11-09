package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MainJdbcTemplate {
  private static final String URL = "jdbc:postgresql://localhost:5432/sidikov_db";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Zaq12wsx";

  //language=SQL
  private static final String SQL_INSERT_USER =
      "INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)";

  //language=SQL
  private static final String SQL_SELECT_ALL =
      "SELECT * FROM owner";


  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);

    JdbcTemplate template = new JdbcTemplate(dataSource);

    template.update(SQL_INSERT_USER, 23, "Инокентий", "Африка");

    HumanRowMapper rowMapper = new HumanRowMapper();

    List<Human> humans = template.query(SQL_SELECT_ALL, rowMapper);

    System.out.println(humans);

  }
}
