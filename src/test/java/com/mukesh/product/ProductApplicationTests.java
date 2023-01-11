package com.mukesh.product;

import com.mukesh.product.model.Product;
import com.mukesh.product.repository.ProductRepository;
import com.mukesh.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	@Test
	public void getAllTest() {
		when(productRepository.findAll()).thenReturn(Stream.of(new Product(1, "Mobile", "samsung", 500),
				new Product(2, "watch", "Fastrack", 5000)).collect(Collectors.toList()));
		assertEquals(2, productService.getProducts().size());
	}

	@Test
	public void saveTest() {
		Product product = new Product(1, "Watch", "Fastrack", 4000);
		when(productRepository.save(product)).thenReturn(product);
		String actualResult=productService.saveProduct(product);
		String expectedResult="Product Added Successfully";
		//assertEquals(product, productService.saveProduct(product));
		assertEquals(expectedResult,actualResult);
	}

	@Test
	public void deleteTest() {
		Product product = new Product(1, "Watch", "Fastrack", 4000);
		productService.deleteProduct(1);
		verify(productRepository, times(1)).deleteById(1);
	}

	@Test
	public void updateTest() {
		Product product = new Product(1, "Mobile", "vivo", 10000);
		int id = product.getId();
		product.setPrice(3000);
		productRepository.save(product);
		when(productRepository.findById(id)).thenReturn(Optional.of(product));
		String actualResult=productService.updateProduct(product);
		String expectedResult="Product Updated Successfully";
		assertEquals(expectedResult,actualResult);

	}
//			@Test
//			public void getTest() {
//				Product product = new Product(2,"watch","fastrack",20000);
//
//				when(productRepository.findById(Integer.valueOf(anyString()))).thenReturn(Optional.of(product));
//				assertEquals(product,productService.saveProduct(id));
//			}

		}

