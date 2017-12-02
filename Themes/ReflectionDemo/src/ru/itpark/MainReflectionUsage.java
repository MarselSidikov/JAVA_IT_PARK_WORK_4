package ru.itpark;

import java.lang.reflect.Field;
import java.util.Scanner;

public class MainReflectionUsage {

  // пакет с фигурами
  private static final String PACKAGE_NAME = "ru.itpark.figures";
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Scanner scanner = new Scanner(System.in);

    // считываем название интересующей нас фигуры
    String className = scanner.next();
    // формируем класс-нейм
    className = PACKAGE_NAME + "." + className;
    // получаем нужный класс
    Class aClass = Class.forName(className);
    // создаем объект класса
    Object anObject = aClass.newInstance();
    // получаем все поля
    Field fields[] = aClass.getDeclaredFields();
    // идем по всем полям
    for (Field field : fields) {
      System.out.println("Введите значение поля:");
      System.out.println(field.getType() + " " + field.getName());
      Object fieldValue;
      // в зависимости от того, какого типа поле
      // считываем нужные данные с консоли
      switch (field.getType().getName()) {
        case "int": fieldValue = scanner.nextInt(); break;
        case "java.lang.String": fieldValue = scanner.next(); break;
        default: throw new IllegalArgumentException("Не поддерживаемый тип");
      }
      // кладем значение поля в объект
      field.setAccessible(true);
      field.set(anObject, fieldValue);
    }

    System.out.println(anObject);
  }
}
