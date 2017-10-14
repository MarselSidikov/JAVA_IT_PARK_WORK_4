package ru.itpark;

public class SystemErrorButtonHandler implements ButtonObserver {
    @Override
    public void handleButtonClick(ClickArgs clickArgs) {
        if (clickArgs.isLeftMouseButton()) {
            System.err.println("НАЖАЛИ ЛЕВУЮ!");
        } else {
            System.err.println("НАЖАЛИ ПРАВУЮ!");
        }
    }
}
