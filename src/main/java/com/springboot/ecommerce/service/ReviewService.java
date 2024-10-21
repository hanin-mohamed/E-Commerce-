package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    Review findById(Long id);
    List<Review> findAllByProductId(Long productId);
    List<Review> findAllByUserName(String userName);

    Review insert(Review review);
    Review update(Review review);
    void delete(Long id);

}
