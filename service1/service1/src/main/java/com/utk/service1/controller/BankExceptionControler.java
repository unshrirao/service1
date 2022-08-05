package com.utk.service1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.utk.service1.exceptions.CustomerInBankNotFoundException;

@ControllerAdvice
public class BankExceptionControler {
    @ExceptionHandler(value = CustomerInBankNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerInBankNotFoundException customerInBankNotFoundException) {
		return new ResponseEntity<Object>("Customer Not Found",HttpStatus.NOT_FOUND);
	}
}
