package com.ishop.service.impl;

import com.ishop.entity.Category;
import com.ishop.entity.Producer;
import com.ishop.entity.Product;
import com.ishop.jdbc.JDBCUtils;
import com.ishop.exception.InternalServerErrorException;
import com.ishop.jdbc.ResultSetHandler;
import com.ishop.jdbc.ResultSetHandlerFactory;
import com.ishop.service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class ProductServiceImpl implements ProductService {
	private static final ResultSetHandler<List<Product>> productsResultSetHandler = 
			ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
	
	private final DataSource dataSource;
	
	public ProductServiceImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> listAllProducts(int page, int limit) {
		try (Connection c = dataSource.getConnection()) {
			int offset = (page - 1) * limit;
			String sql = "select p.name, p.description, p.image_link, p.price," +
					" category.name, brand.name, p.id from product p , brand, category" +
					" where category.id=p.id_category and brand.id=p.id_brand limit ? offset ?";
			return JDBCUtils.select(c, sql, productsResultSetHandler, limit, offset);
//
//			return JDBCUtils.select(c, "select product.*, category.name, brand.name from product, brand, category "
//					+ "where category.id=product.id_category and brand.id=product.id_brand limit ? offset ?", productsResultSetHandler, limit, offset);
		} catch (SQLException e) {
			throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
		}
	}

	@Override
	public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> listAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producer> listAllProducers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
