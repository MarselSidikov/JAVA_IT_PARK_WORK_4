package ru.itpark.lambda;

import ru.itpark.functional.StringModifyRule;
import ru.itpark.functional.StringsModifier;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();
    lines.add("Марсель");
    lines.add("Алексей");
    lines.add("Даниил");
    lines.add("Алмаз");
    lines.add("Загир");

    StringsModifier modifier = new StringsModifier();

    List<String> modified =
        modifier.modifyAll(lines, (source -> source + "!!!"));

    System.out.println(modified);
  }
}
