package ru.itpark.app.forms;

import lombok.Data;
import ru.itpark.app.models.User;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Data
public class UpdateUserForm {
  private String name;
  private String lastName;
  private String birthDate;

  public void update(User model) {
    if (name.equals("")) {
      name = null;
    }

    model.setName(name);

    if (lastName.equals("")) {
      lastName = null;
    }

    model.setLastName(lastName);
    try {
      LocalDate birthDateCandidate = LocalDate.parse(birthDate);
      model.setBirthDate(birthDateCandidate);
    } catch (DateTimeParseException e) {
      model.setBirthDate(null);
    }
  }
}
