package com.example.SpringDataJpaDemo.Service;

import com.example.SpringDataJpaDemo.Repository.UserRepository;
import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.RegisterUserResponseDto;
import com.example.SpringDataJpaDemo.entities.Role;
import com.example.SpringDataJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public RegisterUserResponseDto registerUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setEmail(createUserDto.getEmail());
        user.setName(createUserDto.getName());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);
        return new RegisterUserResponseDto(savedUser.getName(), savedUser.getId());
    }
}
