package ru.itpark.app.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itpark.app.models.User;
import ru.itpark.app.repositories.UsersRepository;

import java.util.function.Supplier;

// Интерфейс, который описывает класс, который
// позволит Spring доставать пользователя из бд
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // без Optional
//    User user = usersRepository.findByEmail(email);
//    if (user != null) {
//      return new UserDetailsImpl(user);
//    } else throw new IllegalArgumentException("User not found by login");
    return new UserDetailsImpl(
        usersRepository.findByEmail(email).orElseThrow(() ->
    new IllegalArgumentException("User not found by login")));
  }
}
