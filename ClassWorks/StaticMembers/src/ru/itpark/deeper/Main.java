package ru.itpark.deeper;

public class Main {
    public static void main(String[] args) {
        System.out.println(SomeClass.someStaticField);
        SomeClass.someStaticField = 200;
        SomeClass object = new SomeClass();
        object.someField = 10;
        System.out.println(object.someStaticField);
        object.someStaticField = 100;

        SomeClass anotherObject = new SomeClass();
        anotherObject.someField = 15;
        anotherObject.someStaticField = 150;

        System.out.println(object.someField);
        System.out.println(anotherObject.someField);

        System.out.println(object.someStaticField);
        System.out.println(anotherObject.someStaticField);
        System.out.println(SomeClass.someStaticField);
    }
}
