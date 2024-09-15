package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
* */
@Configuration
public class ProjectConfig {


    /*
    @Bean annotation, which lets Spring know that it needs to call
    this method when it initializes its context and adds the returned
    value to the context.
    * */
    @Bean
    Vehicle vehicle1() {
        Vehicle veh = new Vehicle();
        veh.setName("Mercedez Benz");
        return veh;
    }

    @Bean
    Vehicle vehicle2() {
        Vehicle veh = new Vehicle();
        veh.setName("Ford Figo");
        return veh;
    }

    @Bean
    Vehicle vehicle3() {
        Vehicle veh = new Vehicle();
        veh.setName("Ferrari GT");
        return veh;
    }

}