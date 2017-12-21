package ru.itpark.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
  private Long id;
  private String name;
  private int age;
  private String citizen;
  private List<Car> cars;
}
