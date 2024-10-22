package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService  {
    private final CategoryRepository repository;

    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Category findByName(String name) {
        return repository.findByName(name);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category insert(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {
        return repository.save(category);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
