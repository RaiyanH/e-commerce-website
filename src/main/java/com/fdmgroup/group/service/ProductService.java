package com.fdmgroup.group.service;

import java.util.List;
import java.util.Optional;

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
	//similar to findAllBooks
	public List<Product> getProductList() {
		return (List<Product>) productRepo.findAll();
	}
	
	// Update Product
	
	public Product findProductById(int id) {
		Optional<Product> result = productRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Product();
	}
	
	public Product updateProduct(Product product) {
		Optional<Product> result = productRepo.findById(product.getId());
		Product existing = result.get();
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		return productRepo.save(existing);
	}

}
