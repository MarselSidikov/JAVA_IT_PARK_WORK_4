package ru.itpark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScopeDemo {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("ru.itpark/context.xml");

    Message message = context.getBean(Message.class);

    System.out.println(message.getText());

    message.setText("WTF?");

    Message anotherMessage = context.getBean(Message.class);

    System.out.println(anotherMessage.getText());
  }
}
