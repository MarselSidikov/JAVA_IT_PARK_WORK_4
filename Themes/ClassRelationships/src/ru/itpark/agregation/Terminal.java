package ru.itpark.agregation;

public class Terminal {
    private Printer printer;
    private int sum;

    public Terminal(int sum) {
        this.sum = sum;
        this.printer = new Printer();
    }

    public int giveMoney(int money) {
        this.sum -= money;
        printer.printCheck();
        return money;
    }
}
