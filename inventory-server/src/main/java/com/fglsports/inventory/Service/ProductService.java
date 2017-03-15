package com.fglsports.inventory.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fglsports.inventory.Model.Product;
import com.fglsports.inventory.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		productRepository.findAll()
				.forEach(products::add);
		return products;
	}

	public Product getProduct(String id) {
		//return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return productRepository.findOne(id);
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(String id, Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(String id) {
		//products.removeIf(t -> t.getId().equals(id));
		productRepository.delete(id);
	}

}
