package ru.itpark;

public class BTR extends WeaponMachine{
    private int bulletsCount;

    public BTR(int bulletsCount) {
        this.bulletsCount = bulletsCount;
    }

    public void fire() {
        System.out.println("BTR FIRE!");
        this.bulletsCount -= 50;
    }

    public int getBulletsCount() {
        return bulletsCount;
    }
}
