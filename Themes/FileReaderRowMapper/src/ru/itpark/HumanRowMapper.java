package ru.itpark;

public class HumanRowMapper implements RowMapper<Human> {
  @Override
  public Human mapRow(String row) {
    String nameAgeHeight[] = row.split(",");

    String name = nameAgeHeight[0];
    int age = Integer.parseInt(nameAgeHeight[1]);
    int height = Integer.parseInt(nameAgeHeight[2]);
    Human result = new Human(
        name, age, height);
    return result;
  }
}
