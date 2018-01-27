package ru.itpark.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.app.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long>{
  Optional<User> findByConfirmString(String confirmString);
  Optional<User> findByEmail(String email);
}
