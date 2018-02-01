package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.app.dto.UserDto;
import ru.itpark.app.forms.UpdateUserForm;
import ru.itpark.app.models.User;
import ru.itpark.app.repositories.UsersRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDto getUserInformation(Authentication authentication) {
    return UserDto.from(usersRepository.findByEmail(authentication.getName())
        .orElseThrow(IllegalArgumentException::new));
  }

  @Override
  public void updateProfile(Authentication authentication, UpdateUserForm form) {
    User user = usersRepository.findByEmail(authentication.getName())
        .orElseThrow(IllegalArgumentException::new);
    form.update(user);
    usersRepository.save(user);
  }
}
