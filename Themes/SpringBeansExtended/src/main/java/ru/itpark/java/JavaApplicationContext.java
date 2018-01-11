package ru.itpark.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaApplicationContext {

    @Bean
    public Restaurant restaurant() {
        return new Restaurant();
    }

    @Bean
    public Waiter girlWaiter() {
        return new GirlWaiter();
    }

    @Bean
    public Waiter oldWaiter() {
        return new OldWaiter();
    }
}
