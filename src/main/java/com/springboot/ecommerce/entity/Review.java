package com.springboot.ecommerce.entity;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Entity
@Table(name = "review")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    @Size(min = 10, message = "Review content must be at least 10 characters")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull(message = "Product ID is required")
    private Product product;

    @ManyToOne
    @NotNull(message = "User is required")
    private User user;

}
