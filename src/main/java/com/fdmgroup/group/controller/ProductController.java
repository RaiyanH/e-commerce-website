package com.fdmgroup.group.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.service.ProductService;

// This is testing for new branch
@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productservice) {
		super();
		this.productService = productservice;
	}

	// Get request to take us to the index page
	@GetMapping("/")
	public String index() {
		return "Index";
	}
// ---------------------------------Raiyan-------------------------
//	@GetMapping("/")
//	public String findAll(Model model) {
//		model.addAttribute("products", productService.getProductList());
//		return "all-products";
//	}
// ---------------------------------Raiyan-------------------------

	// This takes you to the add product page
	@GetMapping("/AddProduct")
	public String addProduct(Product product) {
		return "AddProduct";
	}
	
// ---------------------------------Raiyan-------------------------
//	@GetMapping("/add")
//	public String lunchAddProductPage(Model model) {
//		model.addAttribute("product", new Product());
//		return "add-product";
//	}
// ---------------------------------Raiyan-------------------------
	
	// this adds a product to DB and saves then returns you back to index
	@PostMapping("/SaveProduct")
	public String saveProduct(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "AddProduct";
		}

		this.productService.saveProduct(product);
		return "redirect:/";
	}

// ---------------------------------Raiyan-------------------------
//	@PostMapping("/addproduct")
//	public String createProduct(@Valid Product product, BindingResult result) {
//		if (result.hasErrors()) {
//			return "AddProduct";
//		}
//		productService.saveProduct(product);
//		return "redirect:/";
//
//	}
// ---------------------------------Raiyan-------------------------

	// this takes you to delete product page
	@GetMapping("/DeleteProduct")
	public String goToDeleteProduct() {
		return "DeleteProduct";
	}

	// this deletes the product by id
	@PostMapping("/DeleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId) {
		System.out.println("Product id to delete: " + productId);

		this.productService.deleteProduct(productId);
		return "Index";
	}

	// this takes you to All Products page and displays all products
	@GetMapping("/AllProducts")
	public String goToAllProducts(Model model) {
		model.addAttribute("products",productService.getProductList());
		return "AllProducts";
	}

// ---------------------------------Raiyan-------------------------
//	@GetMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable("id") int id) {
//		productService.deleteProduct(id);
//		return "redirect:/";
//	}
//
//	@GetMapping("/edit/{id}")
//	public String lunchEditPage(Model model, @PathVariable("id") int id) {
//		model.addAttribute("product", productService.findProductById(id));
//		return "edit-product";
//
//	}
//
//	@PostMapping("/updateproduct")
//	public String upadteProduct(Product product) {
//		productService.updateProduct(product);
//		return "redirect:/";
//	}
//----------------------------------Raiyan---------------------------
	
//	@PostMapping("/AllProducts")
//	public String goToAllProducts(@RequestParam int id, @RequestParam String name, @RequestParam String price, Model model) {
//		List<Product> foundproducts = this.productService.getProductList();
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
//		List<Product> allProducts = new ArrayList<Product>(this.productService.getProductList());
//
//		return new ModelAndView("AllProducts", "products", allProducts);
//	}

}
