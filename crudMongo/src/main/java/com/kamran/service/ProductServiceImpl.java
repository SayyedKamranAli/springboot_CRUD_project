package com.kamran.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;

import com.kamran.exception.NoProductFoundException;
import com.kamran.models.Db_Sequence;
import com.kamran.models.Product;
import com.kamran.repository.ProdRepository;
@Service
public class ProductServiceImpl implements IProductService{
	

	@Autowired
	ProdRepository prodRepo;
	
	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		prodRepo.save(product);
		return "Product id:"+ product.getProdId()+" is saved successfully";
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Long prodId) {
		// TODO Auto-generated method stub
		return prodRepo.findById(prodId).get();
	}

	@Override
	public String deleteProductById(Long prodId) {
		// TODO Auto-generated method stub
		boolean delete = false;
		if(prodRepo.existsById(prodId)) {
			prodRepo.deleteById(prodId);
			delete = true;
		}
		return " Product with Id: "+ prodId+" deleted status: "+delete;
	}

	@Override
	public Product updateProduct(Long prodId, Product product) throws NoProductFoundException {
		// TODO Auto-generated method stub
		Optional<Product> existing = prodRepo.findById(prodId);
		Product existProduct =null;
		if(existing.isPresent()) {
			existProduct = existing.get();
			existProduct.setProdName(product.getProdName());
			existProduct.setPrice(product.getPrice());
			existProduct.setDesc(product.getDesc());
			
			prodRepo.save(existProduct);
		}
		if(existProduct==null) {
			throw new NoProductFoundException("Product not found");
		}
		return existProduct;
	}

}
