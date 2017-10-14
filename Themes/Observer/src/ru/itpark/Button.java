package ru.itpark;

public class Button {

    private ButtonObserver buttonObservers[] = new ButtonObserver[10];
    private int count = 0;
    public void addObserver(ButtonObserver observer) {
        buttonObservers[count] = observer;
        count++;
    }
    // нажатие на кнопку
    public void click(ClickArgs clickArgs) {
        for (int i = 0; i < count; i++) {
            buttonObservers[i].handleButtonClick(clickArgs);
        }
    }
}
