package ru.itpark;

public class Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1;
    private static final double DEFAULT_FUEL_AMOUNT = 0;

    private String model;
    protected int mileage;
    private String color;
    protected double fuelConsumption;
    protected double fuelAmount;

    public Car(String model, String color, double fuelConsumption) {
        this.model = model;
        this.color = color;
        this.mileage = 0;
        this.fuelAmount = 0;
        if (fuelConsumption > 0) {
            this.fuelConsumption = fuelConsumption;
        } else {
            this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        }
    }

    public void setFuelAmount(double fuelAmount) {
        if (fuelAmount > 0) {
            this.fuelAmount = fuelAmount;
        } else {
            this.fuelAmount = DEFAULT_FUEL_AMOUNT;
        }
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public String getColor() {
        return color;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void go(int kilometers) {
        this.mileage += kilometers;
        this.fuelAmount -= (kilometers / 100.0) * fuelConsumption;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
