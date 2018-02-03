package ru.itpark.app.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String storageFileName;
  private String originalFileName;

  private long size;
  private String type;
  private String url;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
}
