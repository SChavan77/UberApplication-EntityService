package com.library.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car extends BaseModel{

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    @Enumerated(value= EnumType.STRING)
    private CarType cartType;

    @OneToOne
    private Driver driver;

    @ManyToOne
    private Color color;
}
