package ru.itpark;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    NumbersReader reader = new NumbersReader("input.txt");
	    Sorter sorter = new Sorter(reader);
        try {
            int array[] = sorter.getSortedFromReader();
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
