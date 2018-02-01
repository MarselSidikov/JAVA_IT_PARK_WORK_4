package ru.itpark.app.services;

import org.springframework.security.core.Authentication;
import ru.itpark.app.dto.UserDto;
import ru.itpark.app.forms.UpdateUserForm;

public interface ProfileService {
  UserDto getUserInformation(Authentication authentication);

  void updateProfile(Authentication authentication, UpdateUserForm form);
}
