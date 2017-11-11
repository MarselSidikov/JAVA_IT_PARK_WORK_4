package ru.itpark;

public class AutoRowMapper implements RowMapper<Auto> {
  @Override
  public Auto mapRow(String row) {
    String nameAndColor[] = row.split(",");
    return new Auto(nameAndColor[0], nameAndColor[1]);
  }
}
