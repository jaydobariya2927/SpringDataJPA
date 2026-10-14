package com.example.SpringDataJpaDemo.Controller;

import com.example.SpringDataJpaDemo.Service.AuthService;
import com.example.SpringDataJpaDemo.dto.CreateOrderDto;
import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.RegisterUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> registerUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(createUserDto));
    }
}
