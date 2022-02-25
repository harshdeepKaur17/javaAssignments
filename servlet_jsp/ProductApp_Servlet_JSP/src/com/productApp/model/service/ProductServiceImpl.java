package com.productApp.model.service;

import java.util.List;
import java.util.Optional;

import com.productApp.model.exceptions.DataAccessException;
import com.productApp.model.exceptions.ProductNotFoundException;
import com.productApp.model.persistence.Product;
import com.productApp.model.persistence.ProductDao;
import com.productApp.model.persistence.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	
	public ProductServiceImpl() {
		this.productDao = new ProductDaoImpl();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	public Product updateProduct(int id, Product product) {
		return productDao.updateProduct(id, product);
	}

	@Override
	public List<Product> getAll() throws DataAccessException {
		return productDao.getAll();
	}

	@Override
	public Optional<Product> getById(int id) throws ProductNotFoundException {
		Optional<Product> product = productDao.getById(id);
		return product;
	}

}
