package ru.itpark;

public class Human {
    private int age;
    private String name;

    public Human() {

    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + " " + this.age;
    }

    public boolean equals(Object object) {
        // 1. Проверить, не нулевая ли ссылка
        // 2. Проверить, не ссылка ли это на тот же объект
        // 3. Проверить принадлежность классу
        // 4. Преобразовать
        if (object == null || !(object instanceof Human)) {
            return false;
        }
        if (this == object) {
            return true;
        }

        Human that = (Human)object;
        return this.age == that.age &&
                this.name == that.name;
    }
}
