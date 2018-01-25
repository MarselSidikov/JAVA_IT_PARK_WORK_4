package ru.itpark.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.app.forms.RegistrationForm;
import ru.itpark.app.models.State;
import ru.itpark.app.models.User;
import ru.itpark.app.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class RegistrationServiceImpl implements RegistrationService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private EmailService emailService;

  @Override
  public void registrationUser(RegistrationForm form) {

    String confirmString = UUID.randomUUID().toString();

    User newUser = User.builder()
        .email(form.getEmail())
        .hashPassword(passwordEncoder.encode(form.getPassword()))
        .registrationDate(LocalDateTime.now())
        .state(State.NOT_CONFIRMED)
        .confirmString(confirmString)
        .build();

    String mailText = "<a href=\"http://localhost:8080/confirm/" + confirmString + "\">Подвтердить</a>";

    emailService.sendMail(newUser.getEmail(), "Подтвреждение регистрации", mailText);
    usersRepository.save(newUser);
  }

  @Override
  public boolean confirmUser(String confirmString) {
    Optional<User> userOptional = usersRepository.findByConfirmString(confirmString);

    if (userOptional.isPresent()) {
      User user = userOptional.get();
      user.setConfirmString(null);
      user.setState(State.CONFIRMED);
      usersRepository.save(user);
      return true;
    } else {
      return false;
    }
  }
}
