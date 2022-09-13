package com.fdmgroup.group.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productservice;

	@Autowired
	public ProductController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

	// Get request to take us to the index page
	@GetMapping("/")
	public String index() {
		return "Index";
	}

	// This takes you to the add product
	@GetMapping("/AddProduct")
	public String addProduct(Product product) {
		return "AddProduct";
	}

	// this adds a product to DB and saves then returns you back to index
	@PostMapping("/SaveProduct")
	public String saveProduct(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "AddProduct";
		}

		this.productservice.saveProduct(product);
		return "redirect:/";
	}

	// this takes you to delete product page
	@GetMapping("/DeleteProduct")
	public String goToDeleteProduct() {
		return "DeleteProduct";
	}

	// this deletes the product by id
	@PostMapping("/DeleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId) {
		System.out.println("Product id to delete: " + productId);

		this.productservice.deleteProduct(productId);
		return "Index";
	}

	// this takes you to All Products page and displays all products
	@GetMapping("/AllProducts")
	public String goToAllProducts(Model model) {
		model.addAttribute("products",productservice.getProductList());
		return "AllProducts";
	}
	
//	@PostMapping("/AllProducts")
//	public String goToAllProducts(@RequestParam int id, @RequestParam String name, @RequestParam String price, Model model) {
//		List<Product> foundproducts = this.productservice.getProductList();
//		if (foundproducts.size() > 0) {
//			model.addAttribute("product", foundproducts);
//		} else {
//			model.addAttribute("product", null);
//		}
//
//		return "AllProducts";
//	}
//	
	
//	@PostMapping("/AllProducts")
//	public ModelAndView goToAllProducts1() {
//
//		List<Product> allProducts = new ArrayList<Product>(this.productservice.getProductList());
//
//		return new ModelAndView("AllProducts", "products", allProducts);
//	}

}
