package com.example.SpringDataJpaDemo.Repository;

import com.example.SpringDataJpaDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
