package com.kamran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kamran.exception.NoProductFoundException;
import com.kamran.models.Product;
import com.kamran.service.IProductService;
import com.kamran.service.ProductServiceImpl;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	IProductService productService;

	
	@PostMapping("/save")
	public ResponseEntity<String> createProduct( @RequestBody Product product){
		return new ResponseEntity<String>(productService.saveProduct(product),HttpStatus.OK);
	}
	@GetMapping("/getall")
	
	public ResponseEntity<List<Product>> readAllProduct(){
		return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
	}
	@GetMapping("/get/{prodId}")
	public ResponseEntity<Product> readProductById(@PathVariable Long prodId){
		return new ResponseEntity<Product>(productService.getProductById(prodId),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{prodId}")
	public ResponseEntity<String> deleteById(@PathVariable Long prodId){
		return new ResponseEntity<String>(productService.deleteProductById(prodId),HttpStatus.OK);
	}
	@PostMapping("/update/{prodId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long prodId, @RequestBody Product product) throws NoProductFoundException{
		return new ResponseEntity<Product>(productService.updateProduct(prodId, product),HttpStatus.OK);
	}
}
