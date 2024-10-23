package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?>findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> findAllByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(service.findAllByCategoryId(categoryId));
    }
    @GetMapping("/user/{userName}")
    public ResponseEntity<?> findAllByUserName(@PathVariable String userName){
        return ResponseEntity.ok(service.findAllByUserName(userName));
    }
    @PostMapping()
    public  ResponseEntity<Product>insert(@RequestBody Product product){

        return ResponseEntity.ok(service.insert(product));
    }
    @PutMapping()
    public ResponseEntity<?>update(@RequestBody Product product){
        return ResponseEntity.ok(service.update(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
