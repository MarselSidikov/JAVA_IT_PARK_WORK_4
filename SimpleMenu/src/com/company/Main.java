package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("МЕНЮ:");
        System.out.println("1. Сказать Привет");
        System.out.println("2. Сказать Пока");
        System.out.println("3. Выход");
        // Scanner - тип, класс, позволяющий
        // считывать данные с потока
        // в данном случае - с консоли System.in
        Scanner scanner = new Scanner(System.in);
        // nextInt считывает с консоли число, а затем
        // это число попадает в command
//        int command = scanner.nextInt();
//        if (command == 1) {
//            System.out.println("Привет!");
//        } else if (command == 2) {
//            System.out.println("Пока!");
//        } else if (command == 3) {
//            System.exit(0);
//        } else {
//            System.out.println("Команда не верна!");
//        }
        while (true) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Привет!");
                    break;
                case 2:
                    System.out.println("Пока!");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Команда не верна");
            }
        }
    }
}
