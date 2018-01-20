package ru.itpark.app;

import com.google.common.collect.Lists;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ru.itpark\\context.xml");
    UsersRepository usersRepository = context.getBean(UsersRepository.class);
    System.out.println(usersRepository.findAll());

//    List<User> users = Lists.newArrayList(
//        User.builder().age(26).citizen("Россия").name("Загир").build(),
//        User.builder().age(26).citizen("Россия").name("Алмаз").build(),
//        User.builder().age(19).citizen("Россия").name("Андрей").build(),
//        User.builder().age(19).citizen("Россия").name("Елизавета").build());

//    usersRepository.save(users);

//    for (User user : usersRepository.findAllByAgeGreaterThan(23)) {
//      System.out.println(user);
//    }

    System.out.println(usersRepository.findOneByCitizen("Россия"));
  }
}
