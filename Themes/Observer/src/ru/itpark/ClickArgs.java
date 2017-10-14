package ru.itpark;

// объект, который передается при нажатии мышкой на кнопку
public class ClickArgs {
    // нажата левая кнопка мыши
    private boolean isLeftMouseButton;
    // нажата правая кнопка мыши
    private boolean isRightMouseButton;

    public boolean isLeftMouseButton() {
        return isLeftMouseButton;
    }

    public boolean isRightMouseButton() {
        return isRightMouseButton;
    }

    // два статических метода - билдера

    public static ClickArgs leftMouseButton() {
        // создаем объект
        ClickArgs clickArgs = new ClickArgs();
        // задаем состояние
        clickArgs.isLeftMouseButton = true;
        // возвращаем объект
        return clickArgs;
    }

    public static ClickArgs rightMouseButton() {
        ClickArgs clickArgs = new ClickArgs();
        clickArgs.isRightMouseButton = true;
        return clickArgs;
    }
}
