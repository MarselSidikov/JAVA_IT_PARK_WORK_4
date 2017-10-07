package ru.itpark;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Car camry = new Car(777, "Camry", "Black");
        ParkingPlace parkingPlace = new ParkingPlace(
                LocalTime.parse("20:15"),
                LocalTime.parse("20:30")
        );
        camry.toPark(parkingPlace);
    }
}
