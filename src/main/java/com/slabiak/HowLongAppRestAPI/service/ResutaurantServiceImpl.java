package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.exceptions.RestaurantNotFoundException;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResutaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if(restaurant.isPresent()){
            return restaurant.get();
         } else{
            throw new RestaurantNotFoundException(String.format("Restaurant with id %d is not found.",restaurantId));
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(String name, String address, String google_id, String imageURL) {
        Restaurant restaurant = new Restaurant(name,address,google_id,imageURL);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

}
