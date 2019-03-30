package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ResutaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return restaurant.get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public void createRestaurant(String name, String address, String google_id, String imageURL) {
        Restaurant restaurant = new Restaurant(name,address,google_id,imageURL);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void addReport(Report report, int restaurantId) {
        report.setCreatedAt(new Date());
        Restaurant restaurant = getRestaurantById(restaurantId);
        restaurant.addReport(report);
        restaurantRepository.save(restaurant);
    }
}
