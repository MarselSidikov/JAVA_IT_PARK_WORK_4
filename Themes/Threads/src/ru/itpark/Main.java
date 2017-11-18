package ru.itpark;

public class Main {

    public static void main(String[] args) throws Exception {
//      System.out.println(Thread.currentThread());
//      System.out.println("Привет, я немного торможу");
//      Thread.sleep(10000);
//      System.out.println("Все, отпустило.");

      ThreadGroup group = new ThreadGroup("моя группа");
      MyThread thread = new MyThread(group);
      thread.start();
    }
}
