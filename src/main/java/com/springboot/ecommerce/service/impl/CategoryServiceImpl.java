package com.springboot.ecommerce.service.impl;

import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import com.springboot.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category insert(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
