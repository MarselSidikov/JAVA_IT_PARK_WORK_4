package ru.itpark;

public class ArrayList<T> {
  private Object data[];
  private int count;

  public ArrayList() {
    data = new Object[10];
    count = 0;
  }

  public void add(T element) {
    data[count] = element;
    count++;
  }

  public T get(int index) {
    return (T)data[index];
  }
}
