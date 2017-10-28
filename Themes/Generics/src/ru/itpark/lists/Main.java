package ru.itpark.lists;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
      LinkedList<String> strings = new LinkedList<>();
      strings.add("Hello");
      strings.add("Bye");
      strings.add("Marsel");
      strings.add("Lol");
      strings.add("Сейчас возьмем перерыв");

      LinkedList<Integer> z = new LinkedList<Integer>();
      z.add(456);
      z.add(3);
      z.add(4);

      for (String string : strings) {
        System.out.println(string);
      }

      for (Integer x : z) {
        System.out.println(x);
      }
    }
}
