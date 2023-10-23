package ru.liga.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurant_menu_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantMenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_menu_item_id")
    private Long restMenuItemId;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
}