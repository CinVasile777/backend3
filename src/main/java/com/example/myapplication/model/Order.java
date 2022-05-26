package com.example.myapplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String individual;
    private String legalEntity;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String county;
    private String courier;
    private String postal;
    private String email;
    private String phone;
    private String cashOnDelivery;
    private double orderValue;
    private double delivery;
    private double totalPrice;

//    @Column(name = "order_date")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//    private LocalDate orderDate;

    @OneToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product>listOfProducts;
}
