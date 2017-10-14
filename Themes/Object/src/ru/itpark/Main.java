package ru.itpark;

public class Main {
    public static void main(String[] args) {
        Human marsel = new Human(23, "Марсель");
        Human marsel2 = marsel;
        Human marsel3 = new Human(23, "Марсель");

        // == сравниваем значения
        System.out.println(marsel == marsel2);
        System.out.println(marsel == marsel3);

        System.out.println(marsel.equals(marsel3));
    }
}
