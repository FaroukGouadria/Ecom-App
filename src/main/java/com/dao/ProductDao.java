package com.dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
	
		public boolean ajouterproduct(Product p);
		public List<Product> getAllproducts();
		public Product getBookbyId(int id);
		public boolean updateproduct(Product p);
		public boolean deleteprod(int id);
}
