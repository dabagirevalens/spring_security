package com.example.security.config;

import com.example.security.models.Role;
import com.example.security.models.User;
import com.example.security.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_MANAGER"));
            userService.saveRole(new Role("ROLE_ADMIN"));
            userService.saveRole(new Role("ROLE_SUPER_ADMIN"));


            User david = new User(
                    "SHUMBUSHO David",
                    "david",
                    "qwerty",
                    new ArrayList<>()
            );

            User dabagire = new User(
                    "Valens DABAGIRE",
                    "dabagire",
                    "qwerty",
                    new ArrayList<>()
            );

            userService.saveUser(dabagire);
            userService.saveUser(david);

            userService.addRoleToUser("david", "ROLE_USER");
            userService.addRoleToUser("dabagire", "ROLE_SUPER_ADMIN");
        };
    }

}
