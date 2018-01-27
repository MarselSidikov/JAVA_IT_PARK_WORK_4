package ru.itpark.app.services;

import org.springframework.security.core.Authentication;
import ru.itpark.app.models.User;

public interface ProfileService {
  User getUserInformation(Authentication authentication);
}
