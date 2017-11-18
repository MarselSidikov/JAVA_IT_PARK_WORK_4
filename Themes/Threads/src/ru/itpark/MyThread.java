package ru.itpark;

public class MyThread extends Thread {
  public MyThread(ThreadGroup group) {
    super(group, "MyThread");
  }

  public void run() {
    System.out.println(Thread.currentThread());
    SecondThread secondThread = new SecondThread();
    secondThread.start();
  }

}
