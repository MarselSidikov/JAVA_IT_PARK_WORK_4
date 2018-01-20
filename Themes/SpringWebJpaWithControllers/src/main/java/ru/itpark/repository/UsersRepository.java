package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.models.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
  List<User> findAllByAgeGreaterThan(int age);

  @Query(value = "from User user where user.citizen = 'Россия'")
  List<User> findAllByRussia();

  @Query(nativeQuery = true, value = "SELECT * FROM owner WHERE owner.citizen = ?1 LIMIT 1;")
  User findOneByCitizen(String citizen);
}
