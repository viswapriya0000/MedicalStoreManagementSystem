package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.exceptionhandler.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceTests {
	
	
	@MockBean
	ProductRepository productRepository;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Test
	public void addProduct()  {
		Integer productId=2;
		//LocalDate localDate="2012-10-10";
		Product product=new Product();
		product.setProductId(productId);
		product.setProductBatchNo(5);
		product.setProductCompany("HUL");
		product.setProductDescription("For Fever");
		//product.setProductExpiryDate("2012-10-10");
		product.setProductName("paracetemol");
		product.setProductPrice(20.45f);
		product.setProductQuantity(3);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product,productService.addProduct(product));
		
	}
	
	@Test
	public void getAllProducts() {
		List<Product> pro=new ArrayList<>();
		Product product=new Product();
		product.setProductId(3);
		product.setProductBatchNo(5);
		product.setProductCompany("HUL");
		product.setProductDescription("For Fever");
		//product.setProductExpiryDate("2012-10-10");
		product.setProductName("paracetemol");
		product.setProductPrice(20.45f);
		product.setProductQuantity(3);
		pro.add(product);
		when(productRepository.findAll()).thenReturn(pro);
		assertEquals(1,productService.getAllProducts().size());
	}
	
	
	@Test
	public void updateProduct() throws ProductNotFoundException  {
		Integer productId=2;
		//LocalDate localDate="2012-10-10";
		Product product=new Product();
		product.setProductId(productId);
		product.setProductBatchNo(5);
		product.setProductCompany("HUL");
		product.setProductDescription("For Fever");
		//product.setProductExpiryDate("2012-10-10");
		product.setProductName("paracetemol");
		product.setProductPrice(20.45f);
		product.setProductQuantity(3);
		when(productRepository.save(product)).thenReturn(product);
		//assertEquals(Optional.of(product),productService.updateProduct(productId,product));
		
	}
	
	
	
	/*
	 * @Test public void getProductById() { Integer productId=2; Product product=new
	 * Product(); product.setProductBatchNo(productId);
	 * product.setProductCompany(null); product.setProductDescription(null);
	 * product.setProductExpiryDate(null); product.setProductId(productId);
	 * product.setProductName(null); product.setProductPrice(0);
	 * product.setProductQuantity(productId); product.setProductUrl(null); Billing
	 * bill=new Billing(); bill.setAddress("AP"); bill.setTotalAmount(2000L);
	 * //bill.setProducts(product);
	 * 
	 * //product.setBills(bill);
	 * when(productRepository.findById(productId)).thenReturn(Optional.of(product));
	 * //assertEquals(product,productService.getProductById(productId)); }
	 */
	
	
}
