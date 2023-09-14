package com.kamran.service;

import java.util.List;

import com.kamran.exception.NoProductFoundException;
import com.kamran.models.Product;

public interface IProductService {
String saveProduct(Product product );
List<Product> getAllProduct();
Product getProductById(Long prodId);
String deleteProductById(Long prodId);
Product updateProduct(Long prodId, Product product) throws NoProductFoundException;

}
