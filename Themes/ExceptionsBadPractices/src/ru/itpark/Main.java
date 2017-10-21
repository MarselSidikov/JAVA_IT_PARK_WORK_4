package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            // GOOD!
            throw new IllegalArgumentException(e);
        }

        try {
            int b = inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Файла же нет что ты творишь!!");
        }
    }
}
