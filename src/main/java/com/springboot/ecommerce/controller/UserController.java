package com.springboot.ecommerce.controller;


import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>>findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("")
    public ResponseEntity<List<User>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User user){
        return ResponseEntity.ok(service.insert(user));
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(service.update(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
