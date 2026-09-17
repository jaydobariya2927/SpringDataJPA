package com.example.SpringDataJpaDemo.Service;


import com.example.SpringDataJpaDemo.Repository.UserRepository;
import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    public final UserRepository userRepository;

    public UserDto saveUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        User savedUser = userRepository.save(user);

        return new UserDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
