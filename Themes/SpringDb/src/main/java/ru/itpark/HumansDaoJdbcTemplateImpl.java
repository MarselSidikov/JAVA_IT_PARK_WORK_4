package ru.itpark;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HumansDaoJdbcTemplateImpl implements HumansDao {

    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM owner";
    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "SELECT * FROM owner WHERE id = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_AGE =
            "SELECT * FROM owner WHERE age = ?";
    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "SELECT * FROM owner WHERE name = ?";
    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)";
    //language=SQL
    private static final String SQL_UPDATE_USER =
            "UPDATE owner SET age=?, name=?, citizen=? WHERE id=?";
    //language=SQL
    private static final String SQL_DELETE_USER =
            "DELETE FROM owner WHERE id=?";

    private JdbcTemplate template;

    private RowMapper<Human> rowMapper = new RowMapper<Human>() {
      @Override
      public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Human.builder()
            .id(rs.getLong("id"))
            .age(rs.getInt("age"))
            .name(rs.getString("name"))
            .citizen(rs.getString("citizen"))
            .build();
      }
    };


    public HumansDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Human> findAllByAge(int age) {
        return template.query(SQL_SELECT_BY_AGE, rowMapper, age);
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
        List<Human> result = template.query(SQL_SELECT_BY_ID, rowMapper, id);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public void update(Human model) {
        template.update(SQL_UPDATE_USER,
                model.getAge(),
                model.getName(),
                model.getCitizen(),
                model.getId());
    }

    public void delete(Long id) {
        template.update(SQL_DELETE_USER,id);
    }

    public List<Human> findAll() {
        return template.query(SQL_SELECT_ALL, rowMapper);
    }
}
