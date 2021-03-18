package com.ishop.service;

import com.ishop.entity.Category;
import com.ishop.entity.Producer;
import com.ishop.entity.Product;

import java.util.List;

public interface ProductService {

	List<Product> listAllProducts(int page, int limit);
	
	List<Product> listProductsByCategory(String categoryUrl, int page, int limit);
	
	List<Category> listAllCategories();
	
	List<Producer> listAllProducers();
}
