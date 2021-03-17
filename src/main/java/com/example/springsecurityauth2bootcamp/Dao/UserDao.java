package com.example.springsecurityauth2bootcamp.Dao;

import com.example.springsecurityauth2bootcamp.Repositories.UserRepository;
import com.example.springsecurityauth2bootcamp.auth.AppUser;
import com.example.springsecurityauth2bootcamp.auth.GrantAuthorityImpl;
import com.example.springsecurityauth2bootcamp.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUserName(String username){
        User user  = userRepository.findByUsername(username);
        if(username != null){
            return new AppUser(user.getUsername(), user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        }else{
            throw new RuntimeException();
        }
    }
}
