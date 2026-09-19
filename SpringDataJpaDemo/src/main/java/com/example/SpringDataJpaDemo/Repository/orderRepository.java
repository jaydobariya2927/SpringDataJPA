package com.example.SpringDataJpaDemo.Repository;

import com.example.SpringDataJpaDemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface orderRepository extends JpaRepository<Order, Long>{

}
