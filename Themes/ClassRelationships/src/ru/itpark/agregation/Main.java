package ru.itpark.agregation;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(100);
        System.out.println(terminal.giveMoney(10));
        // terminal.killClient();
    }
}
