package com.utk.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.service1.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
