package com.example.openschoolthirdhomework.repository;

import com.example.openschoolthirdhomework.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("FROM Order o left join fetch o.user")
    List<Order> findAll();

    @Query("FROM Order o left join fetch o.user where o.id=:id")
    Optional<Order> findById(Long id);

}
