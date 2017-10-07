package ru.itpark;

public class Main {

    public static void main(String[] args) {
	    Tank tank = new Tank(10);
	    Lazer lazer = new Lazer(1000);
	    BTR btr = new BTR(10000);

	    WeaponMachine machines[] = {tank, lazer, btr};

	    for (WeaponMachine machine : machines) {
	        machine.fire();
        }

        //WeaponMachine machine = new WeaponMachine();
        WeaponMachine machine;

	    tank.go(10);
    }
}
