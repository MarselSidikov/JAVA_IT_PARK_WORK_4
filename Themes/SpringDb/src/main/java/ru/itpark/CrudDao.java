package ru.itpark;

import java.util.List;

public interface CrudDao<T> {
  void save(T model);
  T find(Long id);
  void update(T model);
  void delete(Long id);

  List<T> findAll();
}
