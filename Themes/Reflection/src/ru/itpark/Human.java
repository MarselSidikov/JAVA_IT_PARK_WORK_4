package ru.itpark;

public class Human {
  public int age;
  public String name;
  private boolean isHuman;

  public void go() {
    System.out.println("Я пошел гулять, и мне " + age + " лет. ");
  }

  public void go(int km) {
    System.out.println("Я пошел гулять " + km + " километров");
  }




  @Override
  public String toString() {
    return "Human: age: " + age + ",  isHuman: " + isHuman;
  }
}
