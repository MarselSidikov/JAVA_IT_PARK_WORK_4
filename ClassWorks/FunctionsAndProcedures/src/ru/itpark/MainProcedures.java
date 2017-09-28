package ru.itpark;

import java.util.Arrays;

public class MainProcedures {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swapInArray(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        swap(x, y);
        System.out.println(x + " " + y);

        int b[] = {0, 1, 2, 3, 4, 5};
        swapInArray(b, 2, 5);

        System.out.println(Arrays.toString(b));
    }
}
