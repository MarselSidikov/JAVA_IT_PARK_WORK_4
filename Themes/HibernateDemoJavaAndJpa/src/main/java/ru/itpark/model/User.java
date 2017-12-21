package ru.itpark.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int age;
  private String citizen;

  @OneToMany(mappedBy = "owner")
  private Set<Car> cars;
}
