package ru.itpark;

import java.util.Scanner;

public class MainThrowNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (password.length() < 8) {
            throw new IllegalArgumentException("Неверная длина пароля");
        }
    }
}
