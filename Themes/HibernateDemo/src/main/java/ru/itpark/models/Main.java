package ru.itpark.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    SessionFactory sessionFactory =
        new Configuration()
            .configure("ru.itpark/hibernate.cfg.xml")
            .buildSessionFactory();

    Session session = sessionFactory.openSession();
    Query<User> userQuery =
        session.createQuery("from User user where user.id = ?", User.class);

    userQuery.setParameter(0, 2L);
    User user = userQuery.getSingleResult();

    userQuery.setParameter(0, 4L);
    //User user1 = userQuery.getSingleResult();
    System.out.println(user);
//    System.out.println(user1);

//    Query<User> usersQuery = session.createQuery("from User", User.class);
//    List<User> users = usersQuery.getResultList();
//    System.out.println(users);

    User newUser = User.builder()
        .name("Налоговик")
        .age(666)
        .citizen("Урюпинск")
        .build();

    session.beginTransaction();
    session.persist(newUser);
    session.getTransaction().commit();
    System.out.println(newUser);
  }
}
