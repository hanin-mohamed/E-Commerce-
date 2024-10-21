package com.springboot.ecommerce.service.impl;


import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.Review;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.ProductRepository;
import com.springboot.ecommerce.repository.ReviewRepository;
import com.springboot.ecommerce.repository.UserRepository;
import com.springboot.ecommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    @Override
    public Review findById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAllByProductId(Long productId) {
        Product product=  productRepo.findById(productId).orElse(null);
        return reviewRepo.findAllByProductId(product.getId());
    }

    @Override
    public List<Review> findAllByUserName(String userName) {
        User user = userRepo.findByName(userName);
        return reviewRepo.findAllByUserName(user.getName());
    }

    @Override
    public Review insert(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepo.save(review);    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }
}
