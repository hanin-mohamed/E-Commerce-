package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepo;
    public ResponseEntity<?> findById(Long id) {
        Optional<User> user= userRepo.findById(id);
        if (user.isEmpty())
            return ResponseEntity.badRequest().body("This User doesn't exist!");

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> findByName(String name) {
        User user= userRepo.findByName(name);
        if (user== null)
            return ResponseEntity.badRequest().body("Product with this name doesn't exist");
        return ResponseEntity.ok(user);    }

    public ResponseEntity<?> findByEmail(String email) {
        User user= userRepo.findByEmail(email);
        if (user== null)
            return ResponseEntity.badRequest().body("User with this email doesn't exist");
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> findAll() {
        List<User> users= userRepo.findAll();
        if (users.isEmpty())
            return ResponseEntity.badRequest().body("There are no users");
        return ResponseEntity.ok(users);
    }

    public User insert(User user) {
        return userRepo.save(user);
    }

    public ResponseEntity<?> update(User user) {
        Long id= user.getId();
        Optional<User> temp= userRepo.findById(id);
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("This user doesn't exist!");
        return ResponseEntity.ok(userRepo.save(user));
    }

    public ResponseEntity<?> delete(Long id) {
        User user= userRepo.findById(id).get();
        if (user== null)
            return ResponseEntity.badRequest().body("This user doesn't exist");
        userRepo.deleteById(id);
        return ResponseEntity.ok("User with id "+ id +" has been deleted successfully!");
    }
}
