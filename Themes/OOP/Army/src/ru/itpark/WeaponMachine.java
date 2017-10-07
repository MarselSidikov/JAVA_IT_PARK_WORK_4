package ru.itpark;

public abstract class WeaponMachine {

    private int mileage;

    public void go(int kilometers) {
        this.mileage = this.mileage + kilometers;
    }

    public abstract void fire();
}
