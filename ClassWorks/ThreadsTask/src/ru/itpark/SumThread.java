package ru.itpark;

public class SumThread extends Thread {
  private int start;
  private int end;

  public SumThread(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public void run() {
    for (int i = start; i < end; i++) {
      Main.result = Main.result + Main.array[i];
    }
  }
}
