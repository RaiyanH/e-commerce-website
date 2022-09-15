package com.fdmgroup.group.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.group.model.Product;
import com.fdmgroup.group.model.repository.ProductRepository;

@SpringBootTest
class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	ProductRepository mockproductRepository;
	
	@MockBean
	Product mockProduct;
	
	
    @Test
    void test_Product_From_ServiceLayer_Is_Saved_To_Repository() {
        productService.saveProduct(mockProduct);
        verify(mockproductRepository).save(mockProduct);
    }
    
    @Test
    void test_Product_From_ServiceLayer_Is_Deleted_From_Repository() {
        productService.deleteProduct(2);
        verify(mockproductRepository).deleteById(2);
    }
    
    @Test
    void test_FindAll_Products_WorksIn_Repository() {
        productService.getProductList();
        verify(mockproductRepository).findAll();
    }
    
    @Test
    void test_FindByIdFinds_ProductBy_Id_In_Repository() {
        productService.findProductById(6);
        verify(mockproductRepository).findById(6);
    }
	
	

}
