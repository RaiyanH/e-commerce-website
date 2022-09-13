package com.fdmgroup.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.model.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;

	@Autowired
	public ProductService(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	// Save Product
	public void saveProduct(Product product) {
		this.productRepo.save(product);
	}

	// Delete Product
	public void deleteProduct(int productId) {
		this.productRepo.deleteById(productId);
	}

	// Get Product List

	public List<Product> getProductList() {
		return (List<Product>) productRepo.findAll();
	}

}
