package com.maketmall.demo.domain;


import com.maketmall.demo.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`order`") // 예약어 주의
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // CREATED, PAID, CANCELLED

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
