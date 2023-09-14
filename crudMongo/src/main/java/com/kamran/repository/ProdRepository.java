package com.kamran.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kamran.models.Product;

public interface ProdRepository extends MongoRepository<Product, Long>{

}
