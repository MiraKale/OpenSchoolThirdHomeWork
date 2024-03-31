package com.example.openschoolthirdhomework.model;


import com.example.openschoolthirdhomework.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(nullable = false)
    private OrderStatus status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;
}
