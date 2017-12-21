package ru.itpark.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();

    configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
    configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/sidikov_db");
    configuration.setProperty("hibernate.connection.username", "postgres");
    configuration.setProperty("hibernate.connection.password", "Zaq12wsx");
    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    configuration.setProperty("show_sql", "true");

    // замена hbm
    configuration.addAnnotatedClass(User.class);
    configuration.addAnnotatedClass(Car.class);

    SessionFactory factory = configuration.buildSessionFactory();

    Session session = factory.openSession();

    Query<User> userQuery =
        session.createQuery("from User user where user.id = ?", User.class);

    userQuery.setParameter(0, 2L);
    User user = userQuery.getSingleResult();
    System.out.println(user);
  }
}
