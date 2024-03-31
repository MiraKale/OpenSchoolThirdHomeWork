package com.example.openschoolthirdhomework.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(mappedBy="user",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Order> orders = new HashSet<>();

}
