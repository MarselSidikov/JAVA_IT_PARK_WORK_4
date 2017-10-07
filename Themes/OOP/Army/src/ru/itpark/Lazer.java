package ru.itpark;

public class Lazer extends WeaponMachine{
    private double powerCount;

    public Lazer(double powerCount) {
        this.powerCount = powerCount;
    }

    public void fire() {
        System.out.println("LAZER FIRE!");
        this.powerCount -= 10;
    }

    public double getPowerCount() {
        return powerCount;
    }
}
