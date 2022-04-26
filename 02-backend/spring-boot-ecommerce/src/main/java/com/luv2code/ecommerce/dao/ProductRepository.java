package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> { // <type, primaryKey>

    // query method: select * from product where category_id=id such as --> http://localhost:8080/api/products/search/findByCategoryId?id=4
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // search for it --> http://localhost:8080/api/products/search/findByNameContaining?name=Java
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
