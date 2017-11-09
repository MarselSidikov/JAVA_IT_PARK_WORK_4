package ru.itpark;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// реадизация интерфейса RowMapper, назначение которого -
// получить по строке ответа из БД объект
public class HumanRowMapper implements RowMapper<Human> {
  public Human mapRow(ResultSet resultSet, int i) throws SQLException {
    return new Human(
        resultSet.getInt("age"),
        resultSet.getString("name"),
        resultSet.getString("citizen")
    );
  }
}
