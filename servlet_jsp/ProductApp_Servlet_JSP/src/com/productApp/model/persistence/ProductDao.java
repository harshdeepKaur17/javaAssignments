package com.productApp.model.persistence;

import java.util.List;
import java.util.Optional;

import com.productApp.model.exceptions.DataAccessException;
import com.productApp.model.exceptions.ProductNotFoundException;

//DAO - Data Access Object
public interface ProductDao {
	public Product addProduct(Product product);
	public void deleteProduct(int id);
	public Product updateProduct(int id,Product product);
	public List<Product> getAll() throws DataAccessException;
	public Optional<Product> getById(int id) throws ProductNotFoundException;
}