package com.dietsodasoftware.carfinder.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HttpInvalidRequestError extends RuntimeException {
    public HttpInvalidRequestError(String message){
        super(message);
    }

    public HttpInvalidRequestError(){
        super();
    }

}
