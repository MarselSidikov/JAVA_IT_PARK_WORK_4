package ru.itpark;

public class DinosaurThread implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("Динозавр");
    }
  }
}
