package com.springboot.ecommerce.controller;


import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Category>findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("")
    public ResponseEntity<List<Category>>findAll(){
            return ResponseEntity.ok(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<Category> insert(@RequestBody Category category){
        return ResponseEntity.ok(service.insert(category));
    }

    @PutMapping()
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok(service.update(category));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
