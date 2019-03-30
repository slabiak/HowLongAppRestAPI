package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(int restaurantId);
    List<Restaurant> getAllRestaurants();
    void createRestaurant(String name, String address, String google_id,String imageURL);
    void addReport(Report report, int restaurantId);
}
