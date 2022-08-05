package com.utk.service1.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utk.service1.model.Bank;
import com.utk.service1.model.Customer;
import com.utk.service1.model.Product;
import com.utk.service1.service.UtkTestService;

@RestController
public class Service1Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UtkTestService utkTestService;
	
	@GetMapping("/greetme")
	public String greetMe() {
		return "Welcome to Utk Service1";
	}
	
	@GetMapping("/getutklist")
	public List<String> getUtkList() {
		return utkTestService.getUtkList();
	}
	
	@GetMapping("/getElementUtkListById")
	public String getElementUtkListById(@RequestParam int id) {
		return utkTestService.getElementUtkListById(id);
	}
	
	@PostMapping("/addelementinutklist")
	public String addTextInUtkList(@RequestParam("text" )String text) {
		return utkTestService.addTextInUtkList(text);
	}
	
	@DeleteMapping("/deleteElementFromUtkList")
	public String deleteElementFromUtkList(@RequestParam int id) {
		return utkTestService.deleteElementFromUtkList(id);
	}
	
	@DeleteMapping("/deleteElementFromUtkListByValue")
	public String deleteElementFromUtkListByValue(@RequestParam String text) {
		return utkTestService.deleteElementFromUtkListByValue(text);
	}
	
	@PutMapping("/updateElementInUtkListById")
	public String updateElementInUtkListById(@RequestParam int id, @RequestParam String text) {
		return utkTestService.updateElementInUtkListById(id,text);
	}
	
	//Bank Entity
	@PostMapping("/addCustomerInBank")
	public String addCustomerInBank(@RequestBody Bank bank) {
		logger.info(bank.toString());
		return utkTestService.addCustomerInBank(bank);
	}
	
	@GetMapping("/getCustomers")
	public List<Bank> getCustomers() {
		return utkTestService.getCustomers();
	}
	
	@GetMapping("/getCustomerByAccountNo")
	public Optional<Bank> getCustomerByAccountNo(@RequestParam int accountNo) {
		return utkTestService.getCustomerByAccountNo(accountNo);
	}
	
	@GetMapping("/getCustomerByCity")
	public List<Bank> getCustomerByCity(@RequestParam String city) {
		return utkTestService.getCustomerByCity(city);
	}
	
	@PutMapping("/updateCustomerInBank")
	public String updateCustomerInBank(@RequestBody Bank bank) {
		return utkTestService.updateCustomerInBank(bank);
	}
	
	@DeleteMapping("/deleteCustomerInBankById")
	public String deleteCustomerInBankById(@RequestParam int accountNo) {
		return utkTestService.deleteCustomerInBankById(accountNo);
	}
	
	//Product Entity
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return utkTestService.getAllProducts();
	}
	
	@GetMapping("/getAllProductsByCategory")
	public List<Product> getAllProductsByCategory(@RequestParam String category) {
		return utkTestService.getAllProductsByCategory(category);
	}
	
	@GetMapping("/getAllProductsByPrice")
	public List<Product> getAllProductsByPrice(@RequestParam int price) {
		return utkTestService.getAllProductsByPrice(price);
	}
	
	@GetMapping("/getAllProductsByPriceRange")
	public List<Product> getAllProductsByPriceRange(@RequestParam int price1,@RequestParam int price2) {
		return utkTestService.getAllProductsByPriceRange(price1,price2);
	}
	
	@GetMapping("/getAllProductsByPriceRangeAndCategory")
	public List<Product> getAllProductsByPriceRangeAndCategory(@RequestParam int price1,@RequestParam int price2,@RequestParam String category) {
		return utkTestService.getAllProductsByPriceRangeAndCategory(price1,price2,category);
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		logger.info(product.toString());
		return utkTestService.addProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		return utkTestService.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProductByProductId")
	public String deleteProductByProductId(@RequestParam int productID) {
		return utkTestService.deleteProductByProductId(productID);
	}
	
	//Customer Entity
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return utkTestService.getAllCustomers();
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		logger.info(customer.toString());
		return utkTestService.addCustomer(customer);
	}
}
