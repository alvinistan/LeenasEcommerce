package com.leenas.leenasCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leenas.leenasCart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
