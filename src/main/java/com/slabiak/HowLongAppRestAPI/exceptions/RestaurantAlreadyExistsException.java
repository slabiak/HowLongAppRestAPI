package com.slabiak.HowLongAppRestAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RestaurantAlreadyExistsException extends RuntimeException {
    public RestaurantAlreadyExistsException(String message){
        super(message);
    }
}
