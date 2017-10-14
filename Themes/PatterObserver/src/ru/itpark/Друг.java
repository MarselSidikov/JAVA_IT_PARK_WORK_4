package ru.itpark;

public class Друг implements Observer {
    @Override
    public void handleEvent() {
        System.out.println("Дай косарь до зп по братске!");
    }
}
