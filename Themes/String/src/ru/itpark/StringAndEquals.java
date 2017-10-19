package ru.itpark;

public class StringAndEquals {
    public static void main(String[] args) {
        String hello1 = "Hello";
        String hello2 = "Hello";
        System.out.println(hello1 == hello2);

        String newHello1 = new String("Hello");
        String newHello2 = new String("Hello");
        System.out.println(newHello1 == newHello2);

        System.out.println(newHello1.intern() == newHello2.intern());

        System.out.println(newHello1.equals(newHello2));
    }
}
