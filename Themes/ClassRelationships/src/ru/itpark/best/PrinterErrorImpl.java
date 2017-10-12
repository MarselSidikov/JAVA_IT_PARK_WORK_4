package ru.itpark.best;

public class PrinterErrorImpl implements Printer {
    @Override
    public void printCheck() {
        System.err.println("YOU NOT GET MONEY");
    }
}
