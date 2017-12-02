package ru.itpark;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Human {
  private Long id;
  private String name;
  private int age;
  private String citizen;
}
