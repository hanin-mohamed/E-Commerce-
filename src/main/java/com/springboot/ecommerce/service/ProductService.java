package com.springboot.ecommerce.service;

import com.springboot.ecommerce.entity.Category;
import com.springboot.ecommerce.entity.Product;
import com.springboot.ecommerce.entity.User;
import com.springboot.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService  {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    public ResponseEntity<?> findById(Long id) {
        Optional<Product> product= productRepository.findById(id);
        if (product.isEmpty())
            return ResponseEntity.badRequest().body("This product doesn't exist");

        return ResponseEntity.ok(product);

    }

    public ResponseEntity<?> findByName(String name) {
        Product product= productRepository.findByName(name);
        if (product== null)
            return ResponseEntity.badRequest().body("Product with this name doesn't exist");

        return ResponseEntity.ok(product);
    }


    public ResponseEntity<?>  findAll() {
        List<Product> products = productRepository.findAll();
        if (products==null)
            return ResponseEntity.badRequest().body("There are no products !");
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<?>  findAllByCategoryId(Long categoryId) {
        ResponseEntity<?> category = categoryService.findById(categoryId);
        if (category==null)
            return ResponseEntity.badRequest().body("There is no category with this id");

        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        if (products.isEmpty())
            return ResponseEntity.badRequest().body("There are no products for this category");

        return ResponseEntity.ok(products);
    }

    public ResponseEntity<?>  findAllByUserName(String userName) {
        ResponseEntity<?> user = userService.findByName(userName);
        if (user==null)
            return ResponseEntity.badRequest().body("There is no user with this name");
        List<Product>products = productRepository.findProductsByUserName(userName);
        if (products.isEmpty())
            return ResponseEntity.badRequest().body("this user doesn't buy any product");

        return ResponseEntity.ok(products);
    }

    public Product insert(Product product) {

        return  productRepository.save(product);
    }

    public ResponseEntity<?>  update(Product product) {
        Long id = product.getId();
        Optional<Product> temp = productRepository.findById(id);
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("This product doesn't exist");

        return ResponseEntity.ok(productRepository.save(product));
    }

    public ResponseEntity<?>  delete(Long id) {
        Optional<Product> temp = productRepository.findById(id);
        if (temp.isEmpty())
            return ResponseEntity.badRequest().body("This product doesn't exist");

        productRepository.deleteById(id);
        return ResponseEntity.ok("Product with id "+ id +" has been deleted successfully!");

    }


}
