package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

  private static final String SQL_FIND_BY_ID =
      "SELECT * FROM owner WHERE id = ?";


  public static void main(String[] args) {
    // создаем объект, который хранит информацию о подключении
    // раньше мы сами все это передавали в DriverManager и
    // сами создавали Connection
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(URL);
    dataSource.setUsername(USER);
    dataSource.setPassword(PASSWORD);
    // данный DataSource передаем JdbcTemplate и он уже сам решит,
    // как работать с Connection
    JdbcTemplate template = new JdbcTemplate(dataSource);

    // никаких Statement и PreparedStatement
    template.update(SQL_INSERT_USER, 23, "Инокентий", "Африка");

    HumanRowMapper rowMapper = new HumanRowMapper();

    // мы запросили в БД всех людей
    // и сразу Java-список
    List<Human> humans = template.query(SQL_SELECT_ALL, rowMapper);

    System.out.println(humans);
    Human human = template.queryForObject(SQL_FIND_BY_ID, rowMapper, 2);
    System.out.println(human);

  }
}
