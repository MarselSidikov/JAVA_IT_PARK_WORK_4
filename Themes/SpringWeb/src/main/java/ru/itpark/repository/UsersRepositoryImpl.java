package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

  //language=SQL
  private static final String SQL_SELECT_ALL_USERS =
      "SELECT * FROM owner";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PersistenceContext
  private EntityManager entityManager;

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
  @Transactional
  public void save(User model) {
    entityManager.persist(model);
  }

  @Override
  public User find(long userId) {
    return null;
  }
}
