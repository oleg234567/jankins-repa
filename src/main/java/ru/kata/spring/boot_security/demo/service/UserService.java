package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import ru.kata.spring.boot_security.demo.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    boolean saveUser(User user);
    boolean deleteUser(Long id);
    void updateUser(User user,Long id);
    User findByUsername(String username);


}
