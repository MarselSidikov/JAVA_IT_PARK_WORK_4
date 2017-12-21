package ru.itpark.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "owner")
@ToString(exclude = "owner")
@Builder
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String model;
  private String number;
  private String color;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;
}
