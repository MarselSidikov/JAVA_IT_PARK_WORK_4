package ru.itpark;

import java.util.Arrays;

public class Sorter {
    private NumbersReader reader;

    public Sorter(NumbersReader reader) {
        this.reader = reader;
    }

    public int[] getSortedFromReader() throws Exception {
        int array[] = reader.readNumbers();
        Arrays.sort(array);
        return array;
    }
}
