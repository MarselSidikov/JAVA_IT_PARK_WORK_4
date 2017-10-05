package ru.itpark;

import java.time.LocalTime;

public class ParkingPlace {
    private final int MAX_SIZE = 5;

    private Car cars[];
    private int count;

    private LocalTime beginTime;
    private LocalTime endTime;

    public ParkingPlace(LocalTime beginTime, LocalTime endTime) {
        cars = new Car[MAX_SIZE];
        count = 0;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public void parkCar(Car car) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(beginTime) &&
                currentTime.isBefore(endTime)) {
            cars[count] = car;
            count++;
        } else {
            System.err.println("Парковка закрыта.");
        }
    }

    public void unparkCar(Car car) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(beginTime) &&
                currentTime.isBefore(endTime)) {
            for (int i = 0; i < count; i++) {
                if (car.getNumber() == cars[i].getNumber()) {
                    for (int j = i; j < count - 1; j++) {
                        cars[j] = cars[j - 1];
                    }
                    count--;
                }
            }
        } else {
            System.err.println("Парковка закрыта.");
        }
    }
}
