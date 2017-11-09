package ru.itpark;

import com.google.common.base.MoreObjects;

public class Human {
  private int age;
  private String name;
  private String citizen;

  public Human(int age, String name, String citizen) {
    this.age = age;
    this.name = name;
    this.citizen = citizen;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public String getCitizen() {
    return citizen;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("age", age)
        .add("name", name)
        .add("citizen", citizen)
        .toString();
  }
}
