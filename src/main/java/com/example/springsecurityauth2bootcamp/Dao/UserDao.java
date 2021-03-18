package com.example.springsecurityauth2bootcamp.Dao;

import com.example.springsecurityauth2bootcamp.Repositories.UserRepository;
import com.example.springsecurityauth2bootcamp.auth.AppUser;
import com.example.springsecurityauth2bootcamp.auth.GrantAuthorityImpl;
import com.example.springsecurityauth2bootcamp.entites.Role;
import com.example.springsecurityauth2bootcamp.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUserName(String username){
        User user  = userRepository.findByUsername(username);
        if(username != null){
            List<Role> roles = user.getRole();
            List<GrantAuthorityImpl> grantAuthorityList = new ArrayList<GrantAuthorityImpl>();
            for(Role role: roles){
                grantAuthorityList.add(new GrantAuthorityImpl(role.getRole()));
            }
            return new AppUser(user.getUsername(),user.getPassword(), grantAuthorityList);

        }else{
            throw new RuntimeException();
        }
    }
}
