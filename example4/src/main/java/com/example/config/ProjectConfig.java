package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Bean(name = "Mercedez")
    Vehicle vehicle1() {
        Vehicle veh = new Vehicle();
        veh.setName("Mercedez Benz");
        return veh;
    }

    @Bean(value = "Ford")
    Vehicle vehicle2() {
        Vehicle veh = new Vehicle();
        veh.setName("Ford Figo");
        return veh;
    }


    @Bean("Ferrari")
    Vehicle vehicle3() {
        Vehicle veh = new Vehicle();
        veh.setName("Ferrari GT");
        return veh;
    }


    /// Primary Annotation is used so that when the name parameter is not passed
    // in the getBean method, then this Bean is returned instead of exception
    // NoUniqueBeanDefinitionException

    // There should be only one @Primary Annotation

    @Primary
    @Bean("McLaren")
    Vehicle vehicle4() {
        Vehicle veh = new Vehicle();
        veh.setName("McLaren Car");
        return veh;
    }

}