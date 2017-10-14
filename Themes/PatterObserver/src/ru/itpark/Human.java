package ru.itpark;

public class Human implements Observable {

    private Observer[] observers = new Observer[3];
    private int count = 0;

    @Override
    public void event() {
        System.out.println("Я выиграл миллион!");
        for (int i = 0; i < count; i++) {
            observers[i].handleEvent();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers[count] = observer;
        count++;
    }
}
