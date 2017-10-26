package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Animal python = new Animal(10);
	    Human marsel = new Human(23);
	    Human daniil = new Human(25);
	    Human radik = new Human(24);

	    ArrayList<Human> list = new ArrayList<>();
	    //list.add(python);
	    list.add(marsel);
	    list.add(daniil);
	    list.add(radik);

	    ArrayList<Animal> animalArrayList = new ArrayList<>();
		animalArrayList.add(python);
		//animalArrayList.add(marsel);
		Human marselFromList = (Human)list.get(0);

	}
}
