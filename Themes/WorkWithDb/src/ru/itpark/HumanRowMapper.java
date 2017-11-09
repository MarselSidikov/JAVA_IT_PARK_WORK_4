package ru.itpark;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HumanRowMapper implements RowMapper<Human> {
  @Override
  public Human mapRow(ResultSet resultSet, int i) throws SQLException {
    return new Human(
        resultSet.getInt("age"),
        resultSet.getString("name"),
        resultSet.getString("citizen")
    );
  }
}
