package com.example.SpringDataJpaDemo.Service;


import com.example.SpringDataJpaDemo.Repository.UserRepository;
import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    public List<UserDto> getusers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }


    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDto(user.getId(), user.getName(), user.getEmail());

    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

  @Transactional
    public UserDto updateUser(Long id, CreateUserDto updateUserDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());

        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }



    @Transactional
    public UserDto patchUSer(Long id, CreateUserDto patchUserDto) {
        User user = userRepository.findById(id).orElseThrow();

        if (patchUserDto.getName() != null) {
            user.setName(patchUserDto.getName());
        }
        if (patchUserDto.getEmail() != null) {
            user.setEmail(patchUserDto.getEmail());
        }

        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public List<UserDto> getUsersPaginated(int page, int pageSize, String direction, String sortBy) {
        Sort sort;
        sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<User> usersPage = userRepository.findAll(pageable);

        List<UserDto> userDtoList = new ArrayList<>();
        usersPage.forEach(user -> userDtoList.add(new UserDto(user.getId(), user.getName(), user.getEmail())));

        return userDtoList;
    }
}
