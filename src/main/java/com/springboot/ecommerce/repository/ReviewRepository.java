package com.springboot.ecommerce.repository;


import com.springboot.ecommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProduct_Id(Long productId);
    List<Review> findAllByUser_Name(String userName);

}
