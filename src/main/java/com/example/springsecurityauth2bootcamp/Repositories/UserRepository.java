package com.example.springsecurityauth2bootcamp.Repositories;

import com.example.springsecurityauth2bootcamp.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
