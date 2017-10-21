package ru.itpark.unchecked;

public class MainArithmeticException {

    public static void main(String[] args) {
	    int a = 8;
	    int b = 0;

	    try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Ну ты и странный");
        }
    }
}
