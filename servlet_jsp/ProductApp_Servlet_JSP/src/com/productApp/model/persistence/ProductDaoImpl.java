package com.productApp.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.productApp.model.exceptions.DataAccessException;
import com.productApp.model.exceptions.ProductNotFoundException;

public class ProductDaoImpl implements ProductDao {

	private Connection connection;

	public ProductDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Product addProduct(Product product) {
		try {
			PreparedStatement insertData = connection
					.prepareStatement("insert into products(" 
			+ "name,price,quantity,mfdate,inspDate) values (?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			insertData.setString(1, product.getName());
			insertData.setDouble(2, product.getPrice());
			insertData.setInt(3, product.getQuantity());
			insertData.setDate(4, product.getMfDate());
			insertData.setDate(5, product.getInspDate());
			insertData.executeUpdate();
			
			ResultSet rs = insertData.getGeneratedKeys();
			
			if(rs.next()) {
				product.setProductId(rs.getInt(1));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		try {
			PreparedStatement deleteData = connection.prepareStatement("delete from products where id=?");
			deleteData.setInt(1, id);
			deleteData.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Product updateProduct(int id, Product product) {
		//Business Logic
		return product;
	}

	@Override
	public List<Product> getAll() throws DataAccessException {
		List<Product> products = new ArrayList<Product>();
		try {
			Product product = null;
			PreparedStatement statement = connection.prepareStatement("select * from products");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4),
						result.getDate(5),result.getDate(6));
				products.add(product);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
		return products;
	}

	@Override
	public Optional<Product> getById(int id) throws ProductNotFoundException {
		Product product = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from product where id=?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4),
						result.getDate(5),result.getDate(6));
			} else {
				throw new ProductNotFoundException("employee with id =" + id + " is not found");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(product);
	}

}
