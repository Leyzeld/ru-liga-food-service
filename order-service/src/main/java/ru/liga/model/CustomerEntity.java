package ru.liga.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
}
