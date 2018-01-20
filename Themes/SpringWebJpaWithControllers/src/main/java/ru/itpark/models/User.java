package ru.itpark.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "cars")
@ToString(exclude = "cars")
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int age;
  private String citizen;

  // https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany

  @ManyToMany(mappedBy = "owners")
  private List<Car> cars;
}
