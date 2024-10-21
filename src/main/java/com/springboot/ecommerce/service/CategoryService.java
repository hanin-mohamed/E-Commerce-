package com.springboot.ecommerce.service;


import com.springboot.ecommerce.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category findById(Long id);
    Category findByName(String name);
    List<Category> findAll();
    Category insert(Category category);
    Category update(Category category);
    void delete(Long id);

}
