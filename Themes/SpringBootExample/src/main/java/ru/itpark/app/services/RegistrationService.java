package ru.itpark.app.services;

import ru.itpark.app.forms.RegistrationForm;

public interface RegistrationService {
  void registrationUser(RegistrationForm form);

  boolean confirmUser(String confirmString);
}
