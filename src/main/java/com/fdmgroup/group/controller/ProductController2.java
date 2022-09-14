package com.fdmgroup.group.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.service.ProductService;

@Controller
public class ProductController2 {

	@Autowired
	ProductService productService;

	// Done
	@GetMapping("/admin")
	public String findAll(Model model) {
		model.addAttribute("products", productService.getProductList());
		return "all-products";
	}

	// Done
	@GetMapping("/add")
	public String lunchAddProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "add-product";
	}

	// Done
	@PostMapping("/addproduct")
	public String createProduct(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "add-product";
		}
		productService.saveProduct(product);
		return "redirect:/admin";

	}

	// To Do -- very different
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/admin";
	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("product", productService.findProductById(id));
		return "edit-product";

	}

	@PostMapping("/updateproduct")
	public String upadteProduct(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-product";
		}
		productService.updateProduct(product);
		return "redirect:/admin";
	}
	
	//This is to get to the About page

	@GetMapping("/about")
	public String getToAboutPage() {
		return "About.html";
	}

	// this takes you to All Products page and displays all products
	@GetMapping("/AllProducts")
	public String goToAllProducts(Model model) {
		model.addAttribute("products", productService.getProductList());
		return "AllProducts";
	}
	
	// Get request to take us to the index page
	@GetMapping("/")
	public String index() {
		return "Index";
	}

}
