package ru.itpark.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itpark.app.models.User;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
  private String email;
  private String name;
  private String lastName;
  private String birthDate;
  private String imageUrl;

  public static UserDto from(User model) {
    UserDto result = UserDto.builder()
        .email(model.getEmail())
        .name(model.getName())
        .lastName(model.getLastName())
        .build();

    if (model.getBirthDate() != null) {
      result.setBirthDate(model.getBirthDate().toString());
    }

    if (model.getImage() != null) {
      result.imageUrl = "/files/" + model.getImage().getStorageFileName();
    }

    return result;
  }
}
