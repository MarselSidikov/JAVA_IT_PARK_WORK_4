package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.app.models.User;
import ru.itpark.app.repositories.UsersRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public User getUserInformation(Authentication authentication) {
    return usersRepository.findByEmail(authentication.getName()).orElseThrow(IllegalArgumentException::new);
  }
}
