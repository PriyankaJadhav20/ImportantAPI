package com.example.updation.repositories;

import com.example.updation.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
