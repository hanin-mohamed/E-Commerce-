package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryService  {
    private final CategoryRepository categoryRepository;

    public ResponseEntity<?> findById(Long id) {
        Optional<Category> category= categoryRepository.findById(id);
        if (category.isEmpty())
            return ResponseEntity.badRequest().body("There is no Category with this id!");

        return ResponseEntity.ok(category);    }

    public ResponseEntity<?> findByName(String name) {
        Category category= categoryRepository.findByName(name);
        if (category==null)
            return ResponseEntity.badRequest().body("There is no Category with this name!");
        return ResponseEntity.ok(category);

    }

    public ResponseEntity<?> findAll() {
        List<Category> products= categoryRepository.findAll();
        if (products== null)
            return ResponseEntity.badRequest().body("There is no products in this category!");
        return ResponseEntity.ok(products);
    }

    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public ResponseEntity<?> update(Category category) {
        Long id = category.getId();

        Optional<Category> temp = categoryRepository.findById(id);
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("There is no Category with this id!");
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    public ResponseEntity<?> delete(Long id) {

        Optional<Category> temp = categoryRepository.findById(id);
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("This category doesn't exist");

        categoryRepository.deleteById(id);
        return ResponseEntity.ok("Category with id "+ id +" has been deleted successfully!");    }
}
