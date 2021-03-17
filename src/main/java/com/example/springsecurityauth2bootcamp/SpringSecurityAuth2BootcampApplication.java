package com.example.springsecurityauth2bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringSecurityAuth2BootcampApplication {


	@GetMapping("/")
	public String index(){
		return "index";
	}

	@GetMapping("/admin/home")
	public String adminHome(){
		return "admin home";
	}

	@GetMapping("/user/home")
	public String userHome(){
		return "User home";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuth2BootcampApplication.class, args);
	}
}
