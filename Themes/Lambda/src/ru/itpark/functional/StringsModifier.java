package ru.itpark.functional;

import java.util.ArrayList;
import java.util.List;

public class StringsModifier {
  // принимает на вход список строк
  // меняет их по правилу, описанному в rule
  public List<String> modifyAll(List<String> source, StringModifyRule rule) {
    List<String> result = new ArrayList<>();

    for (String sourceString : source) {
      result.add(rule.modify(sourceString));
    }

    return result;
  }
}
