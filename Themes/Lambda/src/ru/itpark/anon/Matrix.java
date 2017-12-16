package ru.itpark.anon;

public interface Matrix<T> {
  void set(int row, int column, T value);
  T get(int row, int column);
}
