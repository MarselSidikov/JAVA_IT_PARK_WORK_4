package ru.itpark;

public class SportCar extends Car {

    private final double DEFAULT_N2O_CONSUMPTION = 1;
    private final double DEFAULT_N2O_AMOUNT = 0;

    private double n2OAmount;
    private double n2OConsumption;

    public SportCar(String model, String color, double fuelConsumption, double n2OConsumption) {
        // вызов конструктора класса-предка
        super(model, color, fuelConsumption);
        if (n2OConsumption > 0) {
            this.n2OConsumption = n2OConsumption;
        } else {
            this.n2OConsumption = DEFAULT_N2O_CONSUMPTION;
        }
    }

    public void setN2OAmount(double n2OAmount) {
        if (n2OAmount > 0) {
            this.n2OAmount = n2OAmount;
        } else {
            this.n2OAmount = DEFAULT_N2O_AMOUNT;
        }
    }

    public void go(int kilometers) {
        super.mileage += kilometers;
        super.fuelAmount -= (kilometers / 100.0) * super.fuelConsumption;
        this.n2OAmount -= (kilometers / 100.0) * this.n2OConsumption;
    }
    public double getN2OAmount() {
        return n2OAmount;
    }

    public double getN2OConsumption() {
        return n2OConsumption;
    }
}
