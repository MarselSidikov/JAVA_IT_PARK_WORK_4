package ru.itpark.inheritance;

public class Terminal extends Printer {
    private int sum;

    public Terminal(int sum) {
        this.sum = sum;
    }

    public int giveMoney(int money) {
        this.sum -= money;
        printCheck();
        return money;
    }
}
