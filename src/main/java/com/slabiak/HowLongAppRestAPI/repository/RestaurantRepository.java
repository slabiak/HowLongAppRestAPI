package com.slabiak.HowLongAppRestAPI.repository;

import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
