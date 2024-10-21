package com.springboot.ecommerce.service;


import com.springboot.ecommerce.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);
    List<User> findByName(String name);
    User findByEmail(String email);
    List<User> findAll();
    User insert(User user);
    User update(User user);
    void delete(Long id);

}
