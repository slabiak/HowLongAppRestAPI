package com.slabiak.HowLongAppRestAPI.controller;

import com.slabiak.HowLongAppRestAPI.model.ApiResponse;
import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ApiResponse getAllRestaurants(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setRestaurants(restaurantService.getAllRestaurants());
        return apiResponse;
    }

    @PostMapping("/restaurants")
    public ApiResponse createRestaurnat(@RequestParam("name")String name,@RequestParam("address") String address,@RequestParam("google_id") String google_id,@RequestParam("imageURL") String imageURL){
        restaurantService.createRestaurant(name,address,google_id,imageURL);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setRestaurants(restaurantService.getAllRestaurants());
        return apiResponse;
    }

    @PostMapping("/reports")
    public ApiResponse addReport(@RequestParam("restaurant_id")int restaurantId,@RequestParam("waiting_time") int waitingTime,@RequestParam("created_by") String createdBy){
        Report report = new Report(waitingTime,createdBy);
        restaurantService.addReport(report,restaurantId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setRestaurants(restaurantService.getAllRestaurants());
        return apiResponse;
    }
}
