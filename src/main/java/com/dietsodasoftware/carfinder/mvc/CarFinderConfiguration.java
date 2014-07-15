package com.dietsodasoftware.carfinder.mvc;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
@Configuration
public class CarFinderConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    void init(){

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Bean
    public Module jodaModule(){
        return new JodaModule();
    }
}
