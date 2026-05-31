package com.fooddelivery.restaurant.service;

import java.util.List;

import com.fooddelivery.restaurant.entity.Restaurant;

public interface RestaurantService {

	Restaurant saveRestaurant(Restaurant restaurant);

	List<Restaurant> getAllRestaurants();

	Restaurant getRestaurant(Long id);
	
	

}
