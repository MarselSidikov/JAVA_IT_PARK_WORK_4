package ru.itpark.listeners;

import ru.itpark.repository.UsersRepository;
import ru.itpark.repository.UsersRepositoryEntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();

        EntityManager entityManager =
                Persistence.createEntityManagerFactory("ru.itpark.persistence")
                        .createEntityManager();

        UsersRepository usersRepository = new UsersRepositoryEntityManagerImpl(entityManager);

        context.setAttribute("usersRepository", usersRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
