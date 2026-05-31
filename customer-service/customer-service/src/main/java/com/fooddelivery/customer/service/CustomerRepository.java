package com.fooddelivery.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	

}