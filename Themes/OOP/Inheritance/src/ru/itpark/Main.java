package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Car car =
                new Car("Camry", "Black", 12);

        car.setFuelAmount(20);
        car.go(50);
        System.out.println(car.getFuelAmount());

        SportCar sportCar =
                new SportCar("Bugatti", "Blue", 35, 200);

        sportCar.setFuelAmount(100);

        sportCar.go(100);

        SportCar sportCar1 =
                new SportCar("Bugatti", "Blue", 35, 200);

        Car sportCarAsCar = sportCar1;

        sportCarAsCar.go(10);
    }
}
