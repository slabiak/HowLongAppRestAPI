package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(int restaurantId);
    List<Restaurant> getAllRestaurants();
    Restaurant createRestaurant(Restaurant restaurant);
    boolean restaurantExists(String googleId);
}
