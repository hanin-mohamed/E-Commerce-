package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.entity.Review;
import com.springboot.ecommerce.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ResponseEntity<?> review = service.findById(id);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> findAllByProductId(@PathVariable Long productId) {
        ResponseEntity<?> reviews = service.findAllByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> findAllByUserName(@PathVariable String userName) {
        ResponseEntity<?> reviews = service.findAllByUserName(userName);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping()
    public ResponseEntity<?> insert(@Valid @RequestBody Review review, BindingResult result) {

        ResponseEntity<?> newReview = service.insert(review);
        return ResponseEntity.ok(newReview);
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody Review review, BindingResult result ) {

        ResponseEntity<?> updatedReview = service.update(review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.delete(id);
    }
}
