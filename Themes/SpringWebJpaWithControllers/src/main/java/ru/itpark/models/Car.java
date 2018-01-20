package ru.itpark.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "owners")
@ToString(exclude = "owners")
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToMany
    @JoinTable(
            name = "owner_car",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id"))
    private List<User> owners;
}
