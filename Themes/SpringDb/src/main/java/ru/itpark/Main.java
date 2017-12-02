package ru.itpark;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {

    ApplicationContext context =
        new ClassPathXmlApplicationContext("ru.itpark/context.xml");

    HumansDao dao = context.getBean(HumansDao.class);
    System.out.println(dao.findAll());
  }
}
