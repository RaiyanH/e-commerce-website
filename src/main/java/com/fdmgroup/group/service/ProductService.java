package com.fdmgroup.group.service;

import java.util.List;

import com.fdmgroup.group.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	void deleteProduct(int productId);

	List<Product> getProductList();

	Product findProductById(int id);

	Product updateProduct(Product product);

}