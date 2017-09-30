package ru.itpark;

public class Human {
    // члены класса - ПОЛЯ
    // переменные, которые будет иметь
    // каждый объект
    // fields
    // поля задают возможные
    // состояния объектов класса
    private String name;
    private int age;

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    // поведение
    // члены класса - методы
    // methods
    // методы - функции и процедуры внутри класса
    void age() {
        age = age + 1;
    }
}
