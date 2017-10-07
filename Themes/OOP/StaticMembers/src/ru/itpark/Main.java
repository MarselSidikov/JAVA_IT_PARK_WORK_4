package ru.itpark;

public class Main {

    public static void main(String[] args) {
        RationalNumber a = new RationalNumber(4,5);
        RationalNumber b = new RationalNumber(2, 3);
        // a.multiply(b);
        // RationalNumber c = a.multiply(b);
        RationalNumber c = RationalNumber.multiply(a, b);
        System.out.println(a.getNumerator() + "/" + a.getDenominator());
        System.out.println(c.getNumerator() + "/" + c.getDenominator());

    }
}
