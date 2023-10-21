package ru.liga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "courier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "coordinates")
    private Point coordinates;
    @Column(name = "status")
    private String status;
}