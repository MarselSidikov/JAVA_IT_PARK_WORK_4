package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Numbers numbers = Numbers.builder()
                .add(6)
                .add(7)
                .add(8)
                .add(10)
                .build();

        numbers.print();
    }
}
