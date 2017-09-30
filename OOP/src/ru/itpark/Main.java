package ru.itpark;

public class Main {

    public static void main(String[] args) {
	    Human marsel = new Human();
//	    marsel.name = "Marsel";
//	    marsel.age = 23;
        marsel.setName("Марсель");
        marsel.setAge(23);

	    Human liza = new Human();
	    Human ruslan = new Human();
//	    liza.name = "Liza";
//	    liza.age = 19;
//
//	    Human andrey = marsel;
//	    andrey.age = 19;
//        System.out.println(marsel.age);
//        System.out.println(marsel.name);
//        System.out.println(liza.name);

        marsel.age();
        System.out.println(marsel.getAge());
        System.out.println(marsel.getName());

        Human humans[] = {marsel, liza, ruslan};
    }
}
