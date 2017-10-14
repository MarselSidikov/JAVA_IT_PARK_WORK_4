package ru.itpark;

public interface Observable {
    void event();
    void addObserver(Observer observer);
}
