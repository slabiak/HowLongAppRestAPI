package com.slabiak.HowLongAppRestAPI.controller;

import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping()
    public List<Restaurant> getAllRestaurants(){
       return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping()
    public Restaurant createRestaurnat(@RequestBody Restaurant restaurant){
        return restaurantService.createRestaurant(restaurant);
    }
}
