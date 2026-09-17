package com.example.SpringDataJpaDemo.Controller;

import com.example.SpringDataJpaDemo.Service.UserService;
import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(createUserDto));
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestBody CreateUserDto getUserDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getuser(getUserDto));
    }
}
