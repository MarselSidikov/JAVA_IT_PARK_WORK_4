package ru.itpark;

public class Main {

    public static void main(String[] args) {
        // создание объекта строки
        String s = new String();
        // то же самое
        String s1 = "";
        // а что про конкаценацию строк? можно делать явно
        String hello = "Hello";
        hello += "Bye";
        // теперь в hello другая строка, ни в коем случае не та же самая
        System.out.println(hello);
    }
}
