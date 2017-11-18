package ru.itpark;

public class SecondThread extends Thread {
  public void run() {
    System.out.println(Thread.currentThread());
  }
}
