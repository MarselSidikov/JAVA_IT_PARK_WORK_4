package ru.itpark;

public class LeninButtonHandler implements ButtonObserver {
    @Override
    public void handleButtonClick(ClickArgs clickArgs) {
        if (clickArgs.isLeftMouseButton()) {
            System.out.println("Большевики!");
        } else {
            System.out.println("Меньшивики!");
        }
    }
}
