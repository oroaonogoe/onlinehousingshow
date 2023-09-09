package com.example.onlinehousingshow;

import com.example.onlinehousingshow.Repository.RoleRepository;
import com.example.onlinehousingshow.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlinehousingshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinehousingshowApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository) {
		return args -> {
			roleRepository.save(new Role("USER"));
		};
	}

}
