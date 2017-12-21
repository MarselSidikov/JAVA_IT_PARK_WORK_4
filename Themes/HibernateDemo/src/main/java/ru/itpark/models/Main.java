package ru.itpark.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
    System.out.println(user);

  }
}
