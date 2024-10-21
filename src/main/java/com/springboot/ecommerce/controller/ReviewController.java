package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.Review;
import com.springboot.ecommerce.service.ProductService;
import com.springboot.ecommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> findAllByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(service.findAllByProductId(productId));
    }
    @GetMapping("/user/{userName}")
    public ResponseEntity<List<Review>> findAllByUserName(@PathVariable String userName){
        return ResponseEntity.ok(service.findAllByUserName(userName));
    }
    @PostMapping()
    public  ResponseEntity<Review>insert(@RequestBody Review review){

        return ResponseEntity.ok(service.insert(review));
    }
    @PutMapping()
    public ResponseEntity<Review>update(@RequestBody Review review){
        return ResponseEntity.ok(service.update(review));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
