package ru.itpark.streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateAndFunctionAndConsumerMain {
  public static void main(String[] args) {
    Predicate<String> startWithA = s -> s.charAt(0) == 'A';
    Function<String, Integer> countOfLetters = s -> s.length();
    Consumer<String> showConsumer = s -> System.out.println(s);
    System.out.println(startWithA.test("Am"));
    System.out.println(startWithA.test("Fn"));
    System.out.println(countOfLetters.apply("Марсель"));
    showConsumer.accept("Боря");
  }
}
