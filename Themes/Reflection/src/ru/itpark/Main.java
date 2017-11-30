package ru.itpark;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
      // сканнер
      Scanner scanner = new Scanner(System.in);
      // считали имя класса с консоли
	  String className = scanner.next();
      try {
        // создаем объект-класс по названию класса
        // считанного с консоли
        Class aClass = Class.forName(className);
        Object object = aClass.newInstance();

        // если мы имеем класс Human
        if (aClass.getName().equals("ru.itpark.Human")) {
          Class<Human> humanClass = aClass;
          Field field = humanClass.getField("age");
          System.out.println(field.getName());
          System.out.println(field.getType().getName());

          Human human = new Human();

          field.set(human, 134);

          Field fields[] = humanClass.getDeclaredFields();
          for (Field currentField : fields) {
            System.out.println(currentField);
          }

          Field isHumanField = fields[2];

          isHumanField.setAccessible(true);
          isHumanField.set(human, true);
          System.out.println(human);

          Method method = humanClass.getMethod("go");
          method.invoke(human);

          Method anotherMethod = humanClass.getMethod("go", Integer.TYPE);
          anotherMethod.invoke(human, 20);

          Human anotherHuman = humanClass.newInstance();
        }
      } catch (ReflectiveOperationException e) {
        throw new IllegalArgumentException(e);
      }
    }
}
