package ru.liga.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restId;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
}
