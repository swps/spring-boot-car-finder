package com.dietsodasoftware.carfinder.mvc.exception;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class HttpServerError extends RuntimeException {

    public HttpServerError(Throwable e, String reason){
        super(reason, e);
    }

    public HttpServerError(){
        super();
    }
}
