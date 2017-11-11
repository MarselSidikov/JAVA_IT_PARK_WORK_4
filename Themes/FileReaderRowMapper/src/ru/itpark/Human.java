package ru.itpark;

public class Human {
  private String name;
  private int age;
  private int height;

  public Human(String name, int age, int height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getHeight() {
    return height;
  }

  public String toString() {
    return this.name + " " + this.age + " " + this.height;
  }
}
