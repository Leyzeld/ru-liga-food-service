package ru.liga.model;
import lombok.*;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long CourierId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "coordinates")
    private Float coordinates;
    @Column(name = "status")
    private String status;
}