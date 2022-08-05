package com.utk.service1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.service1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findAllByCategory(String category);
	List<Product> findAllByPrice(int price);
	List<Product> findAllByPriceBetween(int price1, int price2);
	List<Product> findAllByPriceBetweenAndCategory(int price1, int price2,String category);
}
