package com.dietsodasoftware.carfinder.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpNotFoundError extends RuntimeException{

    public HttpNotFoundError(String message){
        super(message);
    }

    public HttpNotFoundError(){
        super();
    }

}
