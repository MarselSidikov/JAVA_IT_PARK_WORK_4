package ru.itpark.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;

public class Program {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ru.itpark\\context.xml");
    UsersRepository usersRepository = context.getBean(UsersRepository.class);
    System.out.println(usersRepository.findAll());

    User user = User.builder()
        .age(23)
        .name("Марсель")
        .citizen("Таджикистан")
        .build();

    usersRepository.save(user);
  }
}
