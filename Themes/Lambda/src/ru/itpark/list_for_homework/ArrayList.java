package ru.itpark.list_for_homework;

public class ArrayList {
  private int elements[];
  private int count;

  public ArrayList() {
    elements = new int[10];
    count++;
  }

  public ArrayList add(int element) {
    this.elements[count++] = element;
    return this;
  }
}
