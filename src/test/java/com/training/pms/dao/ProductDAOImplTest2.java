package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.model.Product;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ProductDAOImplTest2 {

	ProductDAO productDAO;
	int productId;
	String productName;
	Product product;
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		productDAO = new ProductDAOImpl();
		productId = 9999;
		product = new Product();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(value = 1)
	void testAddProduct() {
		product = new Product(productId, "Dummy", 10, 100);
		assertTrue(productDAO.addProduct(product));
	}

	@Test
	@Order(value = 2)
	void testSearchByProductId() {
		Product foundProduct = productDAO.searchByProductId(productId);
		product = new Product(productId, "Dummy", 10, 100);
		assertEquals(foundProduct, product);
	}
	@Test
	@Order(value = 3)
	void testUpdateProduct() {
		Product prod = new Product(productId, "NewDummy", 199, 90);
		assertTrue(productDAO.updateProduct(prod));
	}

	@Test
	@Order(value = 4)
	void testGetProducts() {
		List<Product> products = productDAO.getProducts();
		assertNotEquals(0, products.size());
	}
	
	
	@Test
	@Order(value = 5)
	void testDeleteProduct() {
		assertTrue(productDAO.deleteProduct(productId));
	}



	@Test
	@Order(value = 6)
	void testSearchByProductName() {
		
		//fail("Not yet implemented");
	}



	@Test
	@Order(value = 7)
	void testSearchProductByPrice() {
		//fail("Not yet implemented");
	}

	@Test
	@Order(value = 8)
	@DisplayName("Testing product exists-1")
	void testIsProductExists() {
		int productId=2;
		boolean actual = productDAO.isProductExists(productId);
		assertTrue(actual);
	}

}