package ru.itpark.anon;

public class Main {

  public static void main(String[] args) {
    // анонимный класс, в matrix ссылка на
    // объект анонимного класса
    Matrix<Integer> integerMatrix = new Matrix<Integer>() {

      private Integer matrix[][] = new Integer[10][10];

      @Override
      public void set(int row, int column, Integer value) {
        matrix[row][column] = value;
      }

      @Override
      public Integer get(int row, int column) {
        return matrix[row][column];
      }
    };

    integerMatrix.set(1,5,999);
    System.out.println(integerMatrix.get(1,5));

    Matrix<String> stringMatrix = new Matrix<String>() {

      private String[][] matrix = new String[10][10];
      @Override
      public void set(int row, int column, String value) {
        this.matrix[row][column] = value;
      }

      @Override
      public String get(int row, int column) {
        return matrix[row][column];
      }
    };

    stringMatrix.set(5, 1, "Marsel");
    System.out.println(stringMatrix.get(5,1));

    Matrix<Character> characterMatrix = new CharMatrix();
    characterMatrix.set(7,7, 'X');
    System.out.println(characterMatrix.get(7,7));
  }
}
