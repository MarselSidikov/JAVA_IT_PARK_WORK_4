package ru.itpark;

public class Теща implements Observer {
    @Override
    public void handleEvent() {
        System.out.println("АААА УРА ТЫ МОЙ ЛЮБИМЫЙ ЗАТЁК!");
    }
}
