package ru.itpark.repository;

import ru.itpark.models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersRepositoryEntityManagerImpl implements UsersRepository {

    private EntityManager entityManager;

    public UsersRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void save(User model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public User find(long userId) {
        return entityManager.find(User.class, userId);
    }
}
