package ru.itpark.integer;

public class MainInteger {
    public static void main(String[] args) {
        // boxing
        Integer i = new Integer(5);
        // autoboxing
        Integer i1 = 5;

        // unboxing
        int i3 = i.intValue();
        // autounboxing
        int i4 = i;

        int number = Integer.parseInt("1234");

        number++;
        System.out.println(number);
    }
}
