package ru.itpark.unchecked;

public class MainNullPointerException {
    public static void main(String[] args) {
        try {
            int a[] = null;
            a[0] = 10;
        } catch (NullPointerException e) {
            System.out.println("Нул поинтер");
        }
    }
}
