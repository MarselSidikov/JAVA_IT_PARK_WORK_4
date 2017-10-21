package ru.itpark;

import java.io.FileNotFoundException;

public class MainFinally {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            throw new FileNotFoundException("First Exception");
        } catch (FileNotFoundException e) {
            try {
                throw new FileNotFoundException("Exception");
            } catch (FileNotFoundException e1) {
                System.out.println(e1);
                throw new IllegalArgumentException(e1);
            }
        } finally {
            System.out.println("HAHAHA");
        }
    }
}
