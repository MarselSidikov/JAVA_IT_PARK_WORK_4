package ru.itpark.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainStream {
  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();
    lines.add("Марсель");
    lines.add("Алексей");
    lines.add("Даниил");
    lines.add("Алмаз");
    lines.add("Загир");

//    Stream<String> linesStream = lines.stream();
//
//    Stream<String> startWithALines = linesStream
//        .filter(line -> line.charAt(0) == 'А');
//
//    startWithALines.forEach(line -> System.out.println(line));

    lines.stream()
        .filter(line -> line.charAt(0) == 'А')
        .map(line -> line.length())
        .forEach(length -> System.out.println(length));
  }
}
