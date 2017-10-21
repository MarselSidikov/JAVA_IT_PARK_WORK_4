package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NumbersReader {
    private FileInputStream input;

    public NumbersReader(String fileName) {
        try {
            input = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            // best practices of java, better than throws
            throw new IllegalArgumentException(e);
        }
    }

    public int[] readNumbers() throws Exception {
        int array[] = new int[10];
        int count = 0;
        int currentValue = input.read();
        while (currentValue != -1) {
            if (currentValue != 32) {
                array[count] = currentValue - '0';
                count++;
            }
            currentValue = input.read();
        }
        return array;
    }
}
