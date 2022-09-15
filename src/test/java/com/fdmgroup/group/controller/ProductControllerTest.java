package com.fdmgroup.group.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
	@Autowired
	private ProductController2 productController;
	
	@Autowired
	private ProductService productService;
	// Required to run MockMVC requests
	@Autowired
	WebApplicationContext webAppContext;
	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		// Passes the WAC to our mock MVC object so it can perform requests
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void test_Admin_IsReturned_When_All_Dash_Product_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
				.andExpect(MockMvcResultMatchers.view().name("all-products"));

	}
	
	// Test that the controller loads into the Spring Context
	@Test
	public void test_ProductController_Is_Able_To_Load_The_Into_Spring_Context() {
		assertThat(productController).isNotNull();
	}

	// Test that / returns the Index page
	@Test
	public void test_IndexPage_IsReturned_When_ForwadSlash_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("Index"));

	}

	// Test that AddProduct Page is returned
	@Test
	public void test_ProductPage_IsReturned_When_ForwadSlash_AddProduct_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/add")).andExpect(MockMvcResultMatchers.view().name("add-product"));

	}
	@Test
	public void test_AddProduct_IsReturned_When_Add_Dash_Product_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/addproduct")).andExpect(MockMvcResultMatchers.view().name("add-product")).andExpect(MockMvcResultMatchers.view().name("add-product"));

	}
	// Test that DeleteProduct is functioning
	@Test
	public void test_DeleteProductPage_IsReturned_When_ForwadSlash_DeleteProduct_IsPresent() throws Exception {
	
		productService.saveProduct(new Product("TV",4.0));
		
	mockMvc.perform(MockMvcRequestBuilders.get("/delete/1")).andExpect(MockMvcResultMatchers.view().name("redirect:/admin")).andExpect(MockMvcResultMatchers.status().isFound());
	}
	
	//edit test
	@Test
	public void test_editProductPage_() throws Exception {
	
		productService.saveProduct(new Product("Ipad",4.0));
		
	mockMvc.perform(MockMvcRequestBuilders.get("/edit/1")).andExpect(MockMvcResultMatchers.view().name("edit-product")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	// }
	// Test that web is redirected to home page after saving product
	@Test
	public void test_ToSee_If_RedirectedToHomepage_AfterSavingProduct() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("Index"));

	}

	@Test
	public void test_AboutPage_IsReturned_When_ForwadSlash_about_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/about"))
				.andExpect(MockMvcResultMatchers.view().name("About.html"));

	}
	
	  @Test public void test_ProductIsUpdated_When_Requested() throws Exception {
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/updateproduct"))
	  .andExpect(MockMvcResultMatchers.view().name("edit-product"));
	  }

	@Test
	public void test_ThatAllProducts_IsReturned_When_ForwadSlash_AllProduct_IsPresent() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/AllProducts"))
				.andExpect(MockMvcResultMatchers.view().name("AllProducts"));

	}
	@Test
	public void test_ThatCart_IsReturned_When_ForwadSlash_Cart_IsPresent() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cart"))
		.andExpect(MockMvcResultMatchers.view().name("cart"));
		
	}
}

