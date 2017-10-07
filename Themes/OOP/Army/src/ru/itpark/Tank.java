package ru.itpark;

public class Tank extends WeaponMachine{
    private int bulletsCount;

    public Tank(int bulletsCount) {
        this.bulletsCount = bulletsCount;
    }

    public void fire() {
        System.out.println("TANK FIRE!");
        this.bulletsCount--;
    }

    public int getBulletsCount() {
        return bulletsCount;
    }
}
