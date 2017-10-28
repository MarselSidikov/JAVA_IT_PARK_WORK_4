package ru.itpark.comparator;

public class ArrayList<T> {
  private T elements[];
  private int count;

  public ArrayList() {
    this.elements = (T[]) new Object[10];
    this.count = 0;
  }

  public void add(T element) {
    this.elements[count++] = element;
  }

  public T get(int index) {
    return elements[index];
  }

  public void swap(int i, int j) {
    T temp = elements[i];
    elements[i] = elements[j];
    elements[j] = temp;
  }

  public int size() {
    return count;
  }
}
