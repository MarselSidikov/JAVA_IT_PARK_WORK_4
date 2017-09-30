package ru.itpark;

import ru.itpark.models.Car;

public class Main {

    public static void main(String[] args) {
        Car mers = new Car(777, "Black", 200);
        Car bmv = new Car(111, "White", 210);
        Car lada = new Car(666, "Баклажан", 80);
        Car bugatti = new Car(235, "Blue", 1500);

        Car[] cars = {mers, bmv, lada, bugatti};

        for (int i = cars.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (cars[j].getPower() > cars[j + 1].getPower()) {
                    Car temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getCarNumber() + " - " + cars[i].getPower());
        }

    }
}
