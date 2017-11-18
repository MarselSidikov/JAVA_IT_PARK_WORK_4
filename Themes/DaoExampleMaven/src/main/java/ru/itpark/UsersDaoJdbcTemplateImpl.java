package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {

  //language=SQL
  private static final String SQL_SELECT_ALL_USERS = "SELECT o.id AS ownerId,\n" +
      "  o.age AS ownerAge,\n" +
      "  o.citizen AS ownerCitizen,\n" +
      "  o.name as ownerName,\n" +
      "  c.id as carId,\n" +
      "  c.model as carModel,\n" +
      "  c.color as carColor,\n" +
      "  c.number as carNumber,\n" +
      "  c.owner_id as carOwnerId\n" +
      "\n" +
      "FROM owner AS o\n" +
      "LEFT JOIN car AS c ON o.id = c.owner_id;";

  //language=SQL
  private static final String SQL_SELECT_BY_NAME =
      "SELECT * FROM owner WHERE name = ?";

  //language=SQL
  private static final String SQL_INSERT_USER =
      "INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)";

  private JdbcTemplate template;

  private Map<Long, User> usersMap = new HashMap<>();

  private RowMapper<User> rowMapper = (resultSet, rowNum) -> {
    // смотрим, нет ли уже пользователя с таким id в мапе
    if (usersMap.get(resultSet.getLong("ownerId")) == null) {
      User user = User.builder()
          .id(resultSet.getLong("ownerId"))
          .age(resultSet.getInt("ownerAge"))
          .name(resultSet.getString("ownerName"))
          .citizen(resultSet.getString("ownerCitizen"))
          .cars(new ArrayList<>())
          .build();

      usersMap.put(user.getId(), user);
    }

    if (resultSet.getLong("carId") != 0) {
      Car car = Car.builder()
          .id(resultSet.getLong("carId"))
          .model(resultSet.getString("carModel"))
          .color(resultSet.getString("carColor"))
          .number(resultSet.getString("carNumber"))
          .owner(usersMap.get(resultSet.getLong("carOwnerId")))
          .build();

      usersMap.get(car.getOwner().getId()).getCars().add(car);
    }

    return usersMap.get(resultSet.getLong("ownerId"));
  };

  public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  public List<User> findAllByAge(int age) {
    return null;
  }

  public User findOneByName(String name) {
    List<User> result = template.query(SQL_SELECT_BY_NAME, rowMapper, name);
    if (result.size() > 0) {
      return result.get(0);
    }
    return null;
  }

  public void save(User model) {
    template.update(SQL_INSERT_USER, model.getAge(), model.getName(), model.getCitizen());
  }

  public User find(Long id) {
    return null;
  }

  public void update(User model) {

  }

  public void delete(Long id) {

  }

  public List<User> findAll() {
    template.query(SQL_SELECT_ALL_USERS, rowMapper);
    Collection<User> users = usersMap.values();
    List<User> result =  new ArrayList<>(users);
    usersMap.clear();
    return result;
  }
}
