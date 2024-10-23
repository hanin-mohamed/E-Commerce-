package com.springboot.ecommerce.service;


import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.Review;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.ProductRepository;
import com.springboot.ecommerce.repository.ReviewRepository;
import com.springboot.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public ResponseEntity<?>  findById(Long id) {
        Optional<Review> review= reviewRepo.findById(id);
        if (review.isEmpty())
            return ResponseEntity.badRequest().body("This review doesn't exist!");
        return ResponseEntity.ok(review);

    }

    public ResponseEntity<?> findAllByProductId(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isEmpty())
          return   ResponseEntity.badRequest().body("This product doesn't exist!");

        List<Review> reviews = reviewRepo.findAllByProduct_Id(productId);
        if (reviews.isEmpty())
            return ResponseEntity.badRequest().body("This product hasn't been reviewed yet!");
        return ResponseEntity.ok(reviews);

    }

    public ResponseEntity<?> findAllByUserName(String userName) {
        User users = userRepo.findByName(userName);
        if (users == null) {
            return ResponseEntity.badRequest().body("This user doesn't exist!");
        }
        List<Review> reviews = reviewRepo.findAllByUser_Name(userName);
        if (reviews.isEmpty()) {
            throw new RuntimeException("This user hasn't reviewed any product yet!");
        }
        return ResponseEntity.ok(reviews);
    }

    public ResponseEntity<?>  insert(Review review) {
        Optional<Product> product = productRepo.findById(review.getProduct().getId());
        if (product.isEmpty())
            return ResponseEntity.badRequest().body("This product doesn't exist!");

        Optional<User> user = userRepo.findById(review.getUser().getId());
        if (user.isEmpty())
            return ResponseEntity.badRequest().body("This user doesn't exist!");
        review.setProduct(product.get());
        review.setUser(user.get());
        return ResponseEntity.ok(reviewRepo.save(review));
    }

    public ResponseEntity<?>  update(Review review) {
        Optional<Review> temp = reviewRepo.findById(review.getId());
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("This review doesn't exist!");
        return ResponseEntity.ok(reviewRepo.save(review));
    }

    public ResponseEntity<?>  delete(Long id) {
        Optional<Review> review = reviewRepo.findById(id);
        if (review.isEmpty())
            return ResponseEntity.badRequest().body("This review doesn't exist!");
        reviewRepo.deleteById(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
}
