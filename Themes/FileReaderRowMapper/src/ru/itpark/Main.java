package ru.itpark;

import java.util.List;

public class Main {

    public static void main(String[] args) {
      FileTemplate template = new FileTemplate("auto.txt");
      AutoRowMapper autoRowMapper = new AutoRowMapper();
      List<Auto> autos = template.findAll(autoRowMapper);

      for (Auto auto : autos) {
        System.out.println(auto.getColor());
      }
    }
}
