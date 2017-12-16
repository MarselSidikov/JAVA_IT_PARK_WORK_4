package ru.itpark.functional;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    StringModifyRule reverseRule = new StringModifyRule() {
      @Override
      public String modify(String source) {
        return new StringBuilder(source).reverse().toString();
      }
    };
    StringModifyRule smileRule = new StringModifyRule() {
      @Override
      public String modify(String source) {
        return source + "=)";
      }
    };
    List<String> lines = new ArrayList<>();
    lines.add("Марсель");
    lines.add("Алексей");
    lines.add("Даниил");
    lines.add("Алмаз");
    lines.add("Загир");

    StringsModifier modifier = new StringsModifier();

    List<String> reversed = modifier.modifyAll(lines, smileRule);

    System.out.println(reversed);
  }
}
