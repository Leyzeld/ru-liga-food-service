package ru.liga.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "courier")
@Data
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courier_id")
    private Integer id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "coordinates")
    private Point coordinates;
    @Column(name = "status")
    private String status;
}
