package com.example.myapplication.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String firstImage;
    @Column(columnDefinition = "MEDIUMBLOB")
    private String secondImage;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String lastImage;
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Brand brand;
    private String belt;
    private String gender;
    private String battery;

    private UUID modelCode = UUID.randomUUID();

}
