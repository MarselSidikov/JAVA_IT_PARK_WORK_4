package ru.itpark.comparator;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Human marsel = new Human("Марсель", 23);
    Human lex = new Human("Алексей", 27);
    Human almaz = new Human("Алмаз", 25);
    Human zagir = new Human("Загир", 26);
    Human mars = new Human("Марс", 24);
    Human radik = new Human("Радик", 24);
    Human anton = new Human("Антон", 18);

    ArrayList<Human> humans = new ArrayList<>();
    humans.add(mars);
    humans.add(marsel);
    humans.add(radik);
    humans.add(almaz);
    humans.add(anton);
    humans.add(zagir);
    humans.add(lex);

    ArrayListSorter.sort(humans);

    for (int i = 0; i < humans.size(); i++) {
      System.out.println(humans.get(i));
    }

    ArrayList<Scanner> scanners = new ArrayList<>();
    scanners.add(new Scanner(System.in));
    scanners.add(new Scanner(System.in));
    scanners.add(new Scanner(System.in));

    // ArrayListSorter.sort(scanners);
  }
}
