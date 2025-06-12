package com.maketmall.demo.domain;


import jakarta.persistence.*;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private boolean isThumbnail;

    @ManyToOne
    private Product product;
}
