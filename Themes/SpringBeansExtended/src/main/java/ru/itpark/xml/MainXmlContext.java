package ru.itpark.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXmlContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.welcome();
    }
}
