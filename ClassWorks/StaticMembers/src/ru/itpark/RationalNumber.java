package ru.itpark;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;

        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }

//    public void multiply(RationalNumber that) {
//        this.numerator = this.numerator * that.numerator;
//        this.denominator = this.denominator * that.denominator;
//    }

    public RationalNumber multiply(RationalNumber that) {
        return new RationalNumber(
                this.numerator * that.numerator,
                this.denominator * that.denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static RationalNumber multiply(RationalNumber x, RationalNumber y) {
        return new RationalNumber(
                x.numerator * y.numerator,
                x.denominator * y.denominator);
    }
}
