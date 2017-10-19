package ru.itpark.integer;

public class IntegerEquals {
    public static void main(String[] args) {
        Integer i1 = 155;
        Integer i2 = 155;
        System.out.println(i1 == i2);

        Integer i3 = new Integer(55);
        Integer i4 = new Integer(55);
        System.out.println(i3 == i4);
    }
}
