package ru.itpark.checked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainJavaIOExceptions {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("input1.txt");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        byte bytes[] = new byte[100];

        try {
            input.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = new String(bytes);
        System.out.println(text);
    }
}
