package ru.itpark.java;

public class OldWaiter implements Waiter {

    public void giveFood() {
        System.out.println("Я вас не слышу");
    }

    public void takePlates() {
        System.out.println("За собой убрал!");
    }
}
