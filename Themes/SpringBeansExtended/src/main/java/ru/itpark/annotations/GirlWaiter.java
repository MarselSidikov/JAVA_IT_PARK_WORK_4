package ru.itpark.annotations;

import org.springframework.stereotype.Component;

@Component
public class GirlWaiter implements Waiter {
    public void giveFood() {
        System.out.println("Привет, меня зовут Катя! Ваша еда!");
    }

    public void takePlates() {
        System.out.println("Пока, приходите еще!");
    }
}
