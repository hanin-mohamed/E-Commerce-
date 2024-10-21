package com.springboot.ecommerce.service;


import com.springboot.ecommerce.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product findById(Long id);
    Product findByName(String name);
    List<Product> findAll();
    Product insert(Product product);

    Product update(Product product);

    void delete(Long id);

}
