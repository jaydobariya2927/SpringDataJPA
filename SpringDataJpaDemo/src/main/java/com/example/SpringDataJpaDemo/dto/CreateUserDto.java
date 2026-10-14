package com.example.SpringDataJpaDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateUserDto {
    @NotBlank
    @NotNull
    @Size(max = 50)
    private String name;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotBlank
    @NotNull
    private String password;

}
