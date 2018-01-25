package ru.itpark.app.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String hashPassword;

  private String email;

  private LocalDateTime registrationDate;

  @Enumerated(EnumType.STRING)
  private State state;

  private String confirmString;
}
