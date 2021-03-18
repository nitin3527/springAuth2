package com.example.springsecurityauth2bootcamp;

import com.example.springsecurityauth2bootcamp.Repositories.UserRepository;
import com.example.springsecurityauth2bootcamp.entites.Role;
import com.example.springsecurityauth2bootcamp.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("pass"));
            Role role1 = new Role();
            List<Role> roles = new ArrayList<Role>();
            roles.add(role1);
            role1.setRole("ROLE_USER");
            Role role2 = new Role();
            role2.setRole("ROLE_ADMIN");
            roles.add(role2);
            user1.setRole(roles);
            role1.setUser(user1);
            role2.setUser(user1);

            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("pass"));
            List<Role> roles2 = new ArrayList<Role>();;
            Role role3 = new Role();
            role3.setRole("ROLE_ADMIN");
            roles2.add(role3);
            user2.setRole(roles2);
            role3.setUser(user2);

            userRepository.save(user1);
            userRepository.save(user2);
            System.out.println("Total users saved::"+userRepository.count());
        }
    }
}
