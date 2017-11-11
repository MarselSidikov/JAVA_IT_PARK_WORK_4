package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class HumansDaoJdbcTemplateImpl implements HumansDao {

  //language=SQL
  private static final String SQL_SELECT_BY_NAME =
      "SELECT * FROM owner WHERE name = ?";

  //language=SQL
  private static final String SQL_INSERT_USER =
      "INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)";

  private JdbcTemplate template;

  private RowMapper<Human> rowMapper = (resultSet, rowNum) -> {
    Human result = Human.builder()
        .id(resultSet.getLong("id"))
        .age(resultSet.getInt("age"))
        .name(resultSet.getString("name"))
        .citizen(resultSet.getString("citizen"))
        .build();

    return result;
  };

  public HumansDaoJdbcTemplateImpl(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  public List<Human> findAllByAge(int age) {
    return null;
  }

  public Human findOneByName(String name) {
    List<Human> result = template.query(SQL_SELECT_BY_NAME, rowMapper, name);
    if (result.size() > 0) {
      return result.get(0);
    }
    return null;
  }

  public void save(Human model) {
    template.update(SQL_INSERT_USER, model.getAge(), model.getName(), model.getCitizen());
  }

  public Human find(Long id) {
    return null;
  }

  public void update(Human model) {

  }

  public void delete(Long id) {

  }

  public List<Human> findAll() {
    return null;
  }
}
