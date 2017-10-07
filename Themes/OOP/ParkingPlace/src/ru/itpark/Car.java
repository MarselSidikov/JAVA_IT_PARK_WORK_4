package ru.itpark;

public class Car {
    private final int MIN_NUMBER_VALUE = 1;
    private final int MAX_NUMBER_VALUE = 999;
    private final int DEFAULT_NUMBER_VALUE = 1;

    // поля, fields
    // хранят состояние
    private int number;
    private String model;
    private String color;

    public Car(int number, String model, String color) {
        if (number >= MIN_NUMBER_VALUE && number <= MAX_NUMBER_VALUE) {
            this.number = number;
        } else {
            System.err.println("Error");
            this.number = DEFAULT_NUMBER_VALUE;
        }
        this.model = model;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void toPark(ParkingPlace parkingPlace) {
        parkingPlace.parkCar(this);
    }

    public void goFromPark(ParkingPlace parkingPlace) {
        parkingPlace.unparkCar(this);
    }
}
