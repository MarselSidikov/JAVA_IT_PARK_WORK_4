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

  // конструктор, принимает на вход
  // необходимое количество потоков
  public ThreadPool(int threadsCount) {
    this.threadsCount = threadsCount;
    // создали пустую очередь задач
    tasks = new ConcurrentLinkedDeque<>();
    // создали массив переменных
    // для потоков пула
    threads = new ThreadWorker[threadsCount];
    // пробегаем по каждому элементу массива
    for (int i = 0; i < threadsCount; i++) {
      // создаем поток
      threads[i] = new ThreadWorker();
      // запускаем поток
      threads[i].start();
    }
  }
  // кладем задачу
  public void submitTask(Runnable task) {
    // блокирует очередь задач
    synchronized (tasks) {
      // кладет задачу
      tasks.add(task);
      // говорит, всем потокам что освободил очередь
      // но реагирует только один
      tasks.notify();
    }
  }

  // один из потоков пула
  private class ThreadWorker extends Thread {
    // переопределяем метод run, который
    // как раз и будет решать задачу в побочном потоке
    public void run() {

      // переменная для задачи, которую этот
      // поток может взять
      Runnable task;

      // поток все время запущен
      while (true) {
        // занимаем список задач
        synchronized (tasks) {
          // пока в задачах ничего нет
          do {
            try {
              // мы ждем поступления этих задач
              // и вызова notify
              // ОСВОБОЖДАЕТ МОНИТОР
              tasks.wait();
            } catch (InterruptedException e) {
              throw new IllegalStateException(e);
            }
          } while (tasks.isEmpty());
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
