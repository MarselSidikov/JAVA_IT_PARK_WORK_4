package ru.itpark;

import java.util.Scanner;

public class WordsReader {

    private Scanner scanner;

    private Logger logger = SimpleLogger.getInstance();

    public WordsReader() {
        scanner = new Scanner(System.in);
    }

    public void readWord() {
        String word = scanner.next();
        logger.log("Считано слово " + word);
    }
}
