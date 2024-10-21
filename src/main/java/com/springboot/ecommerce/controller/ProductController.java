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
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product>findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> findAllByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(service.findAllByCategoryId(categoryId));
    }
    @GetMapping("/user/{userName}")
    public ResponseEntity<List<Product>> findAllByUserName(@PathVariable String userName){
        return ResponseEntity.ok(service.findAllByUserName(userName));
    }
    @PostMapping()
    public  ResponseEntity<Product>insert(@RequestBody Product product){

        return ResponseEntity.ok(service.insert(product));
    }
    @PutMapping()
    public ResponseEntity<Product>update(@RequestBody Product product){
        return ResponseEntity.ok(service.update(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
