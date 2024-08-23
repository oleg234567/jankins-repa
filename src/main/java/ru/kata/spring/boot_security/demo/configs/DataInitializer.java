package ru.kata.spring.boot_security.demo.configs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner init(UserServiceImpl userService, RoleRepository roleRepository) {
        return args -> {
            Role userRole = new Role();
            userRole.setRole("ROLE_USER");
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setRole("ROLE_ADMIN");
            roleRepository.save(adminRole);

            User user = new User();
            user.setUsername("oleg");
            user.setPassword("oleg123");
            user.setEmail("oleg@mail.ru");
            user.setAge(12);
            user.setRoles(new ArrayList<>(List.of(userRole)));
            userService.saveUser(user);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setEmail("admin@mail.ru");
            admin.setRoles(new ArrayList<>(List.of(adminRole)));
            userService.saveUser(admin);
        };
    }
}
