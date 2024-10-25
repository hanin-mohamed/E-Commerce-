package com.springboot.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "is required")
    private String name;

    @Column(name = "stock")
    @NotNull(message = "is required")
    private Long stock;

    @Column(name = "price")
    @NotNull(message = "is required")
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    // add relation entities
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    private List<Review> reviews;
}
