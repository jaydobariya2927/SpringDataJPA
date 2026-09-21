package com.example.SpringDataJpaDemo.Controller;

import com.example.SpringDataJpaDemo.Service.orderService;
import com.example.SpringDataJpaDemo.dto.CreateOrderDto;
import com.example.SpringDataJpaDemo.dto.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/{userId}/order")
public class OrderController {
    private final orderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@PathVariable Long userId, @RequestBody CreateOrderDto createOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userId, createOrderDto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getorderByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByuserId(userId));
    }
}
