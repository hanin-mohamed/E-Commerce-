package com.springboot.ecommerce.service;


import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.Review;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.ProductRepository;
import com.springboot.ecommerce.repository.ReviewRepository;
import com.springboot.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    public Review findById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    public List<Review> findAllByProductId(Long productId) {
        return reviewRepo.findAllByProduct_Id(productId);
    }

    public List<Review> findAllByUserName(String userName) {
        return reviewRepo.findAllByUser_Name(userName);
    }

    public Review insert(Review review) {
        Product product = productRepo.findById(review.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepo.findById(review.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        review.setProduct(product);
        review.setUser(user);
        return reviewRepo.save(review);
    }

    public Review update(Review review) {
        return reviewRepo.save(review);    }

    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
