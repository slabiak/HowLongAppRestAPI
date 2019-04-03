package com.slabiak.HowLongAppRestAPI.repository;

import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    @Query("select r from Restaurant r where r.googleId = :googleId")
    Restaurant findRestaurantByGoogleId(@Param("googleId") String googleId);
}
