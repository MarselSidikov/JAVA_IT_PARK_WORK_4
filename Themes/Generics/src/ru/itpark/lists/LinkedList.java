package ru.itpark.lists;

import java.util.Iterator;

// LinkedList<T> - объявление обобщенного класса
// Iterable<T> - указание того, что объекты Iterable имеют тип T
public class LinkedList<T> implements Iterable<T> {

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node<T> currentNode = head;

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      T value = currentNode.value;
      currentNode = currentNode.next;
      return value;
    }
  }

  private static class Node<E> {
    // значение, которое хранит узел
    E value;
    // указатель на следующий узел
    Node<E> next;

    Node(E value) {
      this.value = value;
    }
  }

  // указатель на начало списка
  private Node<T> head;

  // указатель на конец списка
  private Node<T> tail;

  private int count;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  public void add(T element) {
    Node<T> newNode = new Node<>(element);
    if (tail == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    count++;
  }

  public void addToBegin(T object) {
    Node<T> newNode = new Node<>(object);
    if (head == null) {
      tail = newNode;
    }

    // для нового узла следующий элемент -
    // тот, который был первым в списке
    newNode.next = head;
    // теперь первый элемент списка - новый
    head = newNode;
    count++;
  }

  public void remove(Object object) {

  }

  public T get(int index) {
    if (index < 0 && index >= count) {
      throw new IllegalArgumentException();
    }
    // начинаем с первого элемнта
    Node<T> currentNode = head;
    // пока i меньше, чем index идем дальше
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    // значение currentNode
    return currentNode.value;
  }

  public int indexOf(T object) {
    return 0;
  }

  public int size() {
    return count;
  }
}
