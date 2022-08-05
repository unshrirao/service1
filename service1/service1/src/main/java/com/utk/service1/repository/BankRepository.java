package com.utk.service1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.service1.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{
	List<Bank> findByCity(String city);
}
