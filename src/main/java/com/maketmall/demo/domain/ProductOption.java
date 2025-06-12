package com.maketmall.demo.domain;

import jakarta.persistence.*;

@Entity
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 예: "흰색 / M"

    private int stock;

    @ManyToOne
    private Product product;
}
