package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService  {

    private final ProductRepository productRepository;
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);

    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategoryId(categoryId);
    }

    public List<Product> findAllByUserName(String userName) {
        return productRepository.findProductsByUserName(userName);
    }

    public Product insert(Product product) {
        return  productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
