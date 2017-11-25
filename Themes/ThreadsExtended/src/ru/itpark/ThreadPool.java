package ru.itpark;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool {

  // количество потоков
  private final int threadsCount;

  // массив потоков
  private final ThreadWorker threads[];

  // очередь задач
  private final Deque<Runnable> tasks;


  public ThreadPool(int threadsCount) {
    this.threadsCount = threadsCount;

    tasks = new ConcurrentLinkedDeque<>();

    threads = new ThreadWorker[threadsCount];

    for (int i = 0; i < threadsCount; i++) {
      threads[i] = new ThreadWorker();
      threads[i].start();
    }
  }

  public void submitTask(Runnable task) {
    synchronized (tasks) {
      tasks.add(task);
      tasks.notify();
    }
  }

  // один из потоков пула
  private class ThreadWorker extends Thread {
    public void run() {

      // переменная для задачи, которую этот
      // поток может взять
      Runnable task;

      // поток все время запущен
      while (true) {
        // занимаем список задач
        synchronized (tasks) {
          // пока в задачах ничего нет
          while (tasks.isEmpty()) {
            try {
              // мы ждем поступления этих задач
              // и вызова notify
              // ОСВОБОЖДАЕТ МОНИТОР
              tasks.wait();
            } catch (InterruptedException e) {
              throw new IllegalStateException(e);
            }
          }
        }
        // как только кто-то вызвал notify
        // поток забирает задачу
        task = tasks.removeFirst();
        // и выполняет ее
        task.run();
      }
    }
  }
}
