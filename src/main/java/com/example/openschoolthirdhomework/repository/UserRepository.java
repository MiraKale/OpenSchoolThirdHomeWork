package com.example.openschoolthirdhomework.repository;


import com.example.openschoolthirdhomework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u left join fetch u.orders")
    List<User> findAll();
    @Query("FROM User u left join fetch u.orders where u.id=:id")
    Optional<User> findById(Long id);
}
