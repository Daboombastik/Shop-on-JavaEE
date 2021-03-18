package com.ishop.jdbc;

import com.ishop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ResultSetHandlerFactory {

	public final static ResultSetHandler<Product> PRODUCT_RESULT_SET_HANDLER = new ResultSetHandler<Product>() {
		@Override
		public Product handle(ResultSet rs) throws SQLException {
			Product p = new Product();
			p.setName(rs.getString(1));
			p.setDescription(rs.getString(2));
			p.setImageLink(rs.getString(3));
			p.setPrice(rs.getBigDecimal(4));
			p.setCategory(rs.getString(5));
			p.setProducer(rs.getString(6));
			p.setId(rs.getInt(7));
			return p;
		}
	};

	public final static <T> ResultSetHandler<T> getSingleResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
		return new ResultSetHandler<T>() {
			@Override
			public T handle(ResultSet rs) throws SQLException {
				if (rs.next()) {
					return oneRowResultSetHandler.handle(rs);
				} else {
					return null;
				}
			}
		};
	}

	public final static <T> ResultSetHandler<List<T>> getListResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
		return new ResultSetHandler<List<T>>() {
			@Override
			public List<T> handle(ResultSet rs) throws SQLException {
				List<T> list = new ArrayList<>();
				while (rs.next()) {
					list.add(oneRowResultSetHandler.handle(rs));
				}
				return list;
			}
		};
	}

	private ResultSetHandlerFactory() {
	}
}
