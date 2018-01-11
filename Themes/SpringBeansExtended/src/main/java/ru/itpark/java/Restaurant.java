package ru.itpark.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Restaurant {

    @Autowired
    @Qualifier(value = "oldWaiter")
    private Waiter waiter;

    public void welcome() {
        waiter.giveFood();
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
