package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "owner")
@ToString(exclude = "owner")
@Builder
public class Car {
  private Long id;
  private String model;
  private String number;
  private String color;
  private User owner;
}
