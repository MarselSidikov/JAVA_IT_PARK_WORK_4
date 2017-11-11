package ru.itpark;

public interface RowMapper<T> {
  T mapRow(String row);
}
