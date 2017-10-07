package ru.itpark.deeper;

public class SomeClass {
    public int someField;
    // static-поля ГЛОБАЛЬНЫ ДЛЯ ВСЕХ ОБЪЕКТОВ
    public static int someStaticField = 111;

    public SomeClass() {
        someField = 10;
    }

    static {
        someStaticField = 777;
    }

    public void someMethod() {
        someField = 100;
        someStaticField = 200;
    }

    public static void someStaticMethod() {
        someStaticField = 300;
        // someField = 100;
    }
}
