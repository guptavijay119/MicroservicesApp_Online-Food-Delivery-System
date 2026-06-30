package com.fooddelivery.customer.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.customer.entity.Customer;
import com.fooddelivery.customer.service.CustomerRepository;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;

		//http://localhost:8081/customers/getdata/1	
	
	
	
	@GetMapping("/current-user")
	public String getLogin(Principal principal) {
		
		
		
		return principal.getName();
	}
	   
	   
    @PostMapping("/savedata")
    public Customer createCustomer(@RequestBody Customer customer) {
           System.out.println("hi this is save api methods");

        return repository.save(customer);
    }
    
    
    //find all table data 
    @GetMapping("/allDataFetch")
    public List<Customer> getdata() {
    	
    	List<Customer> alldata=repository.findAll();
    	
    	return alldata;
    }
    
    
    
    
    @GetMapping("/getdata/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		System.out.println("hi this is get api methods");

		return repository.findById(id).orElse(null);
	}
    

   

    

}
