package ru.liga.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private OrderEntity orderId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_menu_item_id")
    @ToString.Exclude
    private RestaurantMenuItemEntity restaurantMenuItemEntity;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Long quantity;

}