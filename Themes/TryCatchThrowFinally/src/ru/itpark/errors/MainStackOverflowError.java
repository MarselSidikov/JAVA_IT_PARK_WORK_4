package ru.itpark.errors;

public class MainStackOverflowError {
    public static int f(int n) {
//        if (n == 0) {
//            return 1;
//        }
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        try {
            System.out.println(f(6));
        } catch (StackOverflowError e) {
            System.out.println("Переполнение");
        }
    }
}
