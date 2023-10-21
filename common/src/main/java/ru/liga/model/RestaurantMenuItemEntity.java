package ru.liga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurant_menu_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantMenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "restaurant_menu_item_seq")
    @Column(name = "restaurant_menu_item_id")
    private Long restMenuItemId;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
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