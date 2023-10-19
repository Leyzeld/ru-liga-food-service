package ru.liga.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurant_menu_item")
@Data
public class RestaurantMenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_menu_item_id")
    private Integer restaurant_menu_item_id;
    @Column(name = "restaurant_id")
    private Integer restaurant_id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
}
