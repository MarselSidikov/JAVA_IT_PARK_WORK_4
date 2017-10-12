package ru.itpark.best;

public class Terminal {
    private Printer printer;
    private int sum;

    public Terminal(int sum, Printer printer) {
        this.printer = printer;
        this.sum = 0;
    }

    public int giveMoney(int money) {
        this.sum -= money;
        printer.printCheck();
        return money;
    }
}
