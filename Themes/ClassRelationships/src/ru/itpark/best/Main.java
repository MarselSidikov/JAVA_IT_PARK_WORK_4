package ru.itpark.best;

public class Main {
    public static void main(String[] args) {
        Printer standardPrinter = new PrinterStandardImpl();
        Printer errorPrinter = new PrinterErrorImpl();

        Terminal terminal = new Terminal(100, errorPrinter);
        terminal.giveMoney(10);
    }
}
