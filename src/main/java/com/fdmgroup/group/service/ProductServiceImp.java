package com.fdmgroup.group.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.model.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	private ProductRepository productRepo;

	public ProductServiceImp(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public void saveProduct(Product product) {
		this.productRepo.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		this.productRepo.deleteById(productId);
	}

	@Override
	public List<Product> getProductList() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product findProductById(int id) {
		Optional<Product> result = productRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Product();
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> result = productRepo.findById(product.getId());
		Product existing = result.get();
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		return productRepo.save(existing);
	}

}
