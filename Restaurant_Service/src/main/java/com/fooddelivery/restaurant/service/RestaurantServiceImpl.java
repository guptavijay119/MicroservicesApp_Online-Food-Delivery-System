package com.fooddelivery.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.restaurant.entity.Restaurant;
import com.fooddelivery.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;
	
	
	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		
		
		
		
		return repository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return repository.findAll();
	}
	

	@Override
	public Restaurant getRestaurant(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	

}
