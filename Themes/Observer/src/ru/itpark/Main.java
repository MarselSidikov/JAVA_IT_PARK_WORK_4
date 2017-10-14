package ru.itpark;

public class Main {

    public static void main(String[] args) {
	    Button button = new Button();
        SystemErrorButtonHandler handler = new SystemErrorButtonHandler();
        LeninButtonHandler handler1 = new LeninButtonHandler();
        button.addObserver(handler);
        button.addObserver(handler1);
        button.click(ClickArgs.rightMouseButton());


    }
}
