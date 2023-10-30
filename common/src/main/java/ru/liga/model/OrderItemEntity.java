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
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderId;
    @OneToOne(optional = false)
    @JoinColumn(name = "restaurant_menu_item_id")
    private RestaurantMenuItemEntity restaurantMenuItemEntity;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Long quantity;
}