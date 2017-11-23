package ru.itpark;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int array[];
    public static int result = 0;

    public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);

      int numbersCount = scanner.nextInt();
      array = new int[numbersCount];

      Random random = new Random();
      int sum = 0;
      for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(100);
        sum = sum + array[i];
      }

      int threadsCount = scanner.nextInt();
      SumThread threads[] = new SumThread[threadsCount];

      int start, end = 0;
      int blockSize = numbersCount / threadsCount;
      for (int i = 0; i < threadsCount - 1; i++) {
        start = i * blockSize;
        end = start + blockSize;
        threads[i] = new SumThread(start, end);
      }

      threads[threadsCount -1] = new SumThread(end, numbersCount);

      for (int i = 0; i < threadsCount; i++) {
        threads[i].start();
      }

      for (int i = 0; i < threadsCount; i++) {
        threads[i].join();
      }

      System.out.println(sum);
      System.out.println(result);
    }
}
