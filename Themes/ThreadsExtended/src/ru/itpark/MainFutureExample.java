package ru.itpark;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFutureExample {
  public static void main(String[] args) {
    Callable<Integer> sumEvenTask = () -> {
      int sum = 0;
      Thread.sleep(10000);
      for (int i = 0; i < 1000; i++) {
        if (i % 2 == 0) {
          sum = sum + i;
        }
      }
      return sum;
    };


    Callable<Integer> sumOddTask = () -> {
      int sum = 0;
      for (int i = 0; i < 1000; i++) {
        if (i % 2 == 1) {
          sum = sum + i;
        }
      }
      return sum;
    };

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    Future<Integer> futureResultEven =
        executorService.submit(sumEvenTask);
    Future<Integer> futureResultOdd =
        executorService.submit(sumOddTask);

    try {
      System.out.println(futureResultEven.get());

      for (int i = 0; i < 10000; i++) {
        System.out.println(i);
      }
      System.out.println(futureResultOdd.get());
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}
