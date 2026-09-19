package com.example.SpringDataJpaDemo.Service;

import com.example.SpringDataJpaDemo.Repository.orderRepository;
import com.example.SpringDataJpaDemo.Repository.UserRepository;
import com.example.SpringDataJpaDemo.dto.CreateOrderDto;
import com.example.SpringDataJpaDemo.dto.OrderDto;
import com.example.SpringDataJpaDemo.entities.Order;
import com.example.SpringDataJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class orderService {
    private final orderRepository orderRepository;
    private final UserRepository userRepository;


    public  OrderDto createOrder(Long userId, CreateOrderDto createOrderDto) {
        User user = userRepository.findById(userId).orElseThrow();
        Order order = new Order();
        order.setUser(user);
        order.setProductName(createOrderDto.getProductname());

         Order savedOrder = orderRepository.save(order);

         return new OrderDto(savedOrder.getId(), savedOrder.getProductName(), savedOrder.getUser());
    }
}
