package ru.itpark;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumansDaoJdbcImpl implements HumansDao {

    Connection connection;
    PreparedStatement findAll;
    PreparedStatement findOneByName;
    PreparedStatement findAllByAge;
    PreparedStatement find;
    PreparedStatement save;
    PreparedStatement update;
    PreparedStatement delete;

    public HumansDaoJdbcImpl(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
            findAll = connection.prepareStatement("SELECT * FROM owner");
            findAllByAge = connection.prepareStatement("SELECT * FROM owner WHERE age=?");
            findOneByName = connection.prepareStatement("SELECT * FROM owner WHERE name=?");
            find = connection.prepareStatement("SELECT * FROM owner WHERE id=?");
            save = connection.prepareStatement("INSERT INTO owner(age, name, citizen) VALUES (?, ?, ?)");
            update = connection.prepareStatement("UPDATE owner SET age=?, name=?, citizen=? WHERE id=?");
            delete = connection.prepareStatement("DELETE FROM owner WHERE id=?");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Ошибка создания JdbcImpl");
        }
    }

    private Human createHuman(ResultSet resultSet) {
        try {
            return Human.builder()
                    .id(resultSet.getLong("id"))
                    .age(resultSet.getInt("age"))
                    .name(resultSet.getString("name"))
                    .citizen(resultSet.getString("citizen"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка создания юзверя");
        }
    }

    @Override
    public List<Human> findAllByAge(int age) {
        List<Human> list = new ArrayList<>();
        try {
            findAllByAge.setInt(1, age);
            ResultSet resultSet = findAllByAge.executeQuery();
            while (resultSet.next()) {
                list.add(createHuman(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find All exception");
        }
        return list;
    }

    @Override
    public Human findOneByName(String name) {
        try {
            findOneByName.setString(1, name);
            ResultSet resultSet = findOneByName.executeQuery();
            if (resultSet.next()) {
                return createHuman(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find by one err");
        }
        return null;
    }

    @Override
    public void save(Human model) {
        try {
            if (model.getId() == null) {
                save.setInt(1, model.getAge());
                save.setString(2, model.getName());
                save.setString(3, model.getCitizen());
                save.executeUpdate();
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("save err");
        }


    }

    @Override
    public Human find(Long id) {
        try {
            find.setLong(1, id);
            ResultSet resultSet = find.executeQuery();
            if (resultSet.next()) {
                return createHuman(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find by one err");
        }
        return null;
    }

    @Override
    public void update(Human model) {
        try {
            update.setInt(1, model.getAge());
            update.setString(2, model.getName());
            update.setString(3, model.getCitizen());
            update.setLong(4, model.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("update err");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            delete.setLong(1,id);
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("delete err");
        }
    }

    @Override
    public List<Human> findAll() {
        List<Human> list = new ArrayList<>();
        try {
            ResultSet resultSet = findAll.executeQuery();
            while (resultSet.next()) {
                list.add(createHuman(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find All exception");
        }
        return list;
    }
}
