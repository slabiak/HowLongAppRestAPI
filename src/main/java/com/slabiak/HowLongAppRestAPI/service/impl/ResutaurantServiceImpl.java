package com.slabiak.HowLongAppRestAPI.service.impl;

import com.slabiak.HowLongAppRestAPI.exceptions.RestaurantAlreadyExistsException;
import com.slabiak.HowLongAppRestAPI.exceptions.RestaurantNotFoundException;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.repository.RestaurantRepository;
import com.slabiak.HowLongAppRestAPI.service.RestaurantService;
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
            throw new RestaurantNotFoundException(String.format("Restauacja z id %d nieznaleziona",restaurantId));
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        if(restaurantExists(restaurant.getGoogleId())){
          throw new RestaurantAlreadyExistsException("Wybrana restauracja znajduje sie juz w bazie");
        }else{
            restaurantRepository.save(restaurant);
            return restaurant;
        }

    }

    @Override
    public boolean restaurantExists(String googleId) {
        if(restaurantRepository.findRestaurantByGoogleId(googleId) != null){
            return true;
        }
        return false;
    }

}
