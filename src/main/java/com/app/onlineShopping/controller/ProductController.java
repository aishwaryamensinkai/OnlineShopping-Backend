package com.app.onlineShopping.controller;

import com.app.onlineShopping.model.Product;
import com.app.onlineShopping.repository.ProductRepository;
import com.app.onlineShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repo;
	
	@PostMapping("/saveProduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product saveProduct(@RequestBody Product product) throws Exception,Throwable {
		int tempId = product.getProductId();
		boolean exists = repo.existsById(tempId);
		if(exists && !"".equals(tempId))
		{
			Product productObj = service.fetchProductById(tempId);
			if(productObj != null)
				throw new Exception("Product " + tempId + " Already Exists");
		}
		Product productObj = null;
		productObj = service.saveProduct(product);
		return productObj;
	}
	
	@GetMapping("/getProduct/{productId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product getProductIndb(@PathVariable(value = "productId") int id) throws Exception,Throwable {
		return service.fetchProductById(id);
	}
	
	@GetMapping("/getAllProducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> getAllProducts()
    {
        return service.ferchAllProducts();
    }
}
