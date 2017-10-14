package ru.itpark;

public class Main {

    public static void main(String[] args) {
        WordsReader reader = new WordsReader();
        while (true) {
            reader.readWord();
        }
    }
}
