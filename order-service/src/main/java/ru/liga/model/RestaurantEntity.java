package ru.liga.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@Data
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Integer restaurant_id;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
}
