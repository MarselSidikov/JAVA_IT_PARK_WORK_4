package ru.itpark;

public class StringConcat {
    public static void main(String[] args) {
        StringBuilder hello = new StringBuilder("Hello");
        for (int i = 0; i < 10; i++) {
            hello.append("Marsel");
        }

        String helloAsString = hello.toString();
    }
}
