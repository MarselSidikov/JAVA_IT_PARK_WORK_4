package ru.itpark.errors;

public class MainOutOfMemoryError {
    public static void main(String[] args) {
        try {
            String s[] = new String[2147000000];
        } catch (OutOfMemoryError e) {
            System.out.println("Опять чудишь!");
        }
    }
}
