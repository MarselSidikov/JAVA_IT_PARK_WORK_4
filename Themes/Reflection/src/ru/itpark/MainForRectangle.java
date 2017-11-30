package ru.itpark;

import java.lang.reflect.Constructor;

public class MainForRectangle {
  public static void main(String[] args) throws Exception {
    Class<Rectangle> rectangleClass = Rectangle.class;

    Constructor<Rectangle> rectangleConstructor =
        rectangleClass.getConstructor(Integer.TYPE, Integer.TYPE);

    Rectangle rectangle = rectangleConstructor.newInstance(12, 12);

    int i = 0;
  }
}
