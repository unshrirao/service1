package com.utk.service1.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utk.service1.exceptions.CustomerInBankNotFoundException;
import com.utk.service1.model.Bank;
import com.utk.service1.model.Customer;
import com.utk.service1.model.Product;
import com.utk.service1.repository.BankRepository;
import com.utk.service1.repository.CustomerRepository;
import com.utk.service1.repository.ProductRepository;

@Service
public class UtkTestService {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
   @Autowired
   BankRepository bankRepository;
   
   @Autowired
   ProductRepository productRepository;
   
   @Autowired
   CustomerRepository customerRepository;
   
   List<String> utklist = new ArrayList<String>();
   
   public UtkTestService()
   {
	   utklist.add("Test1");
	   utklist.add("Test2");
   }

   public List<String> getUtkList() {
	   return utklist;
   }
   
   public String getElementUtkListById(int id) {
	   try {
	       return utklist.get(id);
	   }
	   catch(IndexOutOfBoundsException e){
		   return "ID Entered "+id+" is Invalid";
	   }
   }

   public String addTextInUtkList(String text) {
	   utklist.add(text);
	   return "Element add in utk list successfully";
   }

   public String deleteElementFromUtkList(int id) {
	   try {
           utklist.remove(id);
	       return "Element deleted from utk list successfully";
	   }
	   catch(IndexOutOfBoundsException e) {
		   return "ID Entered "+id+" is Invalid";
	   }
   }

   public String deleteElementFromUtkListByValue(String text) {
	   utklist.remove(text);
	   return "Element "+text+" deleted from utk list successfully";
   }

   public String updateElementInUtkListById(int id, String text) {
	   try {
		   utklist.set(id, text);
	       return "Updated "+id+" element in utk list successfully";
	   }
	   catch(IndexOutOfBoundsException e) {
		   return "ID Entered "+id+" is Invalid";
	   }
   }

   //Bank Entity
   public String addCustomerInBank(Bank bank) {
	   bankRepository.save(bank);
	   logger.info(bank.toString()); 
	   return "Customer Details Added Successfully";
   }

   public List<Bank> getCustomers() {
	   return bankRepository.findAll();
   }

   public Optional<Bank> getCustomerByAccountNo(int accountNo) {
	   return bankRepository.findById(accountNo);
   }

   public List<Bank> getCustomerByCity(String city) {
	   return bankRepository.findByCity(city);
   }

   public String updateCustomerInBank(Bank bank) {
	   bankRepository.save(bank);
	   return "Customer Details updated Successfully";
   }

   public String deleteCustomerInBankById(int accountNo) {
	   try {
	       bankRepository.deleteById(accountNo);
	   }catch(Exception e) {
		   logger.error("Exception: ",e);
		   throw new CustomerInBankNotFoundException();
	   }
	   return "Customer Details Deleted Successfully";
   }

   //Product Entity
   public List<Product> getAllProducts() {
	   return productRepository.findAll();
   }
 
   public List<Product> getAllProductsByCategory(String category) {
	   return productRepository.findAllByCategory(category);
   }

   public List<Product> getAllProductsByPrice(int price) {
	   return productRepository.findAllByPrice(price);
   }
   
   public List<Product> getAllProductsByPriceRange(int price1, int price2) {
	   return productRepository.findAllByPriceBetween(price1, price2);
   }
   
   public List<Product> getAllProductsByPriceRangeAndCategory(int price1, int price2, String category) {
	   return productRepository.findAllByPriceBetweenAndCategory(price1, price2, category);
   }

   public String addProduct(Product product) {
	   productRepository.save(product);
	   logger.info(product.toString());  
	   return "Product Details Added Successfully";
   }

   public String updateProduct(Product product) {
	   productRepository.save(product);
	   return "Product Details updated Successfully";
   }

   public String deleteProductByProductId(int productID) {
	   try {
	       productRepository.deleteById(productID);;
	       return "Product Details Deleted Successfully";
	   }catch(Exception e) {
		   logger.error("Exception: ",e);
		   return "Invalid Product ID";
	   }
   }

   //Product Entity
   public List<Customer> getAllCustomers() {
	   return customerRepository.findAll();
   }

   public String addCustomer(Customer customer) {
	   customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
	   customerRepository.save(customer);
	   logger.info(customer.toString()); 
	   return "Customers Details Added Successfully";
   }
}
