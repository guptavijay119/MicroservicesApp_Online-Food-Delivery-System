package com.fooddelivery.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.restaurant.entity.Restaurant;
import com.fooddelivery.restaurant.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
//	 @GetMapping("/{id}")
//	    public String getRestaurant1(@PathVariable Long id) {
//	        return "Restaurant Id : " + id;
//	    }
	

	
	@PostMapping("savedata")
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		
		
		return  service.saveRestaurant(restaurant);
	}
	
	
	
	
	
	@GetMapping("/alldata")
    public List<Restaurant> getAllRestaurants() {

        return service.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(
            @PathVariable Long id) {

        return service.getRestaurant(id);
    }
	
	
	
	
	

}
