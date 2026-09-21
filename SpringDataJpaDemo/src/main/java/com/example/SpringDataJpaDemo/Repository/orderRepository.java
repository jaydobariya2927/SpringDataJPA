package com.example.SpringDataJpaDemo.Repository;

import com.example.SpringDataJpaDemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface orderRepository extends JpaRepository<Order, Long>{
        List<Order> findByUserId(Long userID);
}
