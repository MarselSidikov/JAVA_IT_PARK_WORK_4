package ru.itpark;

import java.util.List;

public interface UsersDao extends CrudDao<User> {
  List<User> findAllByAge(int age);
  User findOneByName(String name);
}
