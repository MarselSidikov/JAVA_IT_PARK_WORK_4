package ru.itpark.anon;

public class CharMatrix implements Matrix<Character> {

  private Character[][] matrix = new Character[10][10];

  @Override
  public void set(int row, int column, Character value) {
    matrix[row][column] = value;
  }

  @Override
  public Character get(int row, int column) {
    return matrix[row][column];
  }
}
