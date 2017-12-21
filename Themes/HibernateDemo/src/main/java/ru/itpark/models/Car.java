package ru.itpark.models;

import lombok.*;
import ru.itpark.models.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Car {
  private Long id;
  private String model;
  private String number;
  private String color;
  private User owner;
}
