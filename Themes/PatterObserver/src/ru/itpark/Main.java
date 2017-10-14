package ru.itpark;

public class Main {

    public static void main(String[] args) {
	    Human бедныйМужик = new Human();
	    бедныйМужик.addObserver(new Друг());
	    бедныйМужик.addObserver(new Теща());
	    бедныйМужик.addObserver(new Девушка());
	    бедныйМужик.event();
    }
}
