package ru.liga.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Data
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Integer id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "restaurant_menu_item_id")
    private Integer restaurant_menu_item_id;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
}
