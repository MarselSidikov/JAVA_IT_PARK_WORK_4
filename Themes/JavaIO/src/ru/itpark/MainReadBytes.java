package ru.itpark;

import java.io.FileInputStream;
import java.io.IOException;

public class MainReadBytes {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("input.txt");
            byte bytes[] = new byte[100];
            int count = input.read(bytes);
            for (int i = 0; i < count; i++) {
                System.out.print(bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
