package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepo;
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User insert(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        return userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
