package com.springboot.ecommerce.security;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class LoginRequest {
    private String name;
    private String password;
}
