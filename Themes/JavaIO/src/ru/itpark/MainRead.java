package ru.itpark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainRead {

    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("input.txt");
            int currentByte = input.read();
            while (currentByte != -1) {
                System.out.println((char)currentByte);
                currentByte = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
