package ru.itpark;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread extends Thread {
  private int start;
  private int end;

  private final static Lock lock = new ReentrantLock();

  public SumThread(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public void run() {
    for (int i = start; i < end; i++) {
//      synchronized (Main.array) {
//        Main.result = Main.result + Main.array[i];
//      }
      lock.lock();
      Main.result = Main.result + Main.array[i];
      lock.unlock();

    }
  }
}
