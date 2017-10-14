package ru.itpark;

import java.time.LocalDateTime;

public class SimpleLogger implements Logger {
    // поле, которое хранит единственный экземлпяр класса
    private static SimpleLogger instance;

    // для того, чтобы нельзя было создавать объекты данного класса
    // необходимо закрыть конструктор
    private SimpleLogger() {

    }

    // но нам необходимо создать хотя бы один объект
    // делаем это в статическом инициализаторе
    static {
        instance = new SimpleLogger();
    }

    // создаем метод для получения объекта
    public static SimpleLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println(LocalDateTime.now() + " " + message);
    }
}
