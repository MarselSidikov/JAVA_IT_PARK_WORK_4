package ru.itpark.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaApplicationContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaApplicationContext.class);

        Restaurant restaurant = context.getBean(Restaurant.class);

        restaurant.welcome();
    }
}
