package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itpark.models.User;

import java.util.List;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

  //language=SQL
  private static final String SQL_SELECT_ALL_USERS =
      "SELECT * FROM owner";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(SQL_SELECT_ALL_USERS,
        (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .citizen(row.getString("citizen"))
            .build());
  }

  @Override
  public void save(User model) {

  }

  @Override
  public User find(long userId) {
    return null;
  }
}
