package com.maketmall.demo.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int price;

    @ManyToOne
    private Category category;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product")
    private List<ProductOption> options;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
