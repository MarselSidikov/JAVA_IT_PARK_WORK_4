package ru.itpark.models;

public class Car {
    private int carNumber;
    private String color;
    private int power;

    // конструктор
    // НЕ ЯВЛЯЕТСЯ ЧЛЕНОМ КЛАССА
    // НЕ МЕТОД
    // это набор инструкций, выполняющих инициализацию объекта
    public Car(int carNumber, String color, int power) {
        setCarNumber(carNumber);
        setColor(color);
        setPower(power);
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power >= 0) {
            this.power = power;
        } else {
            this.power = 0;
        }
    }
}
