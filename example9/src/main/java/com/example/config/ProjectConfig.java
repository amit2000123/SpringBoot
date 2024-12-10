package com.example.config;


import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the configuration
class.
* */
@Configuration

public class ProjectConfig {

    /*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
* */
    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    /*
   Here in the below code, we are trying to wire or establish a relationship between Person and
   Vehicle, by invoking the vehicle() bean method from person() bean method.

   Spring will make sure to have only 1 vehicle bean is created and also vehicle bean will
   be created first always as person bean has dependency on it.
   * */

    // however the no. of times Vehicle method is called, only one Bean is created inside the
    // IOC container

    // So, first Vehicle Bean is created when vehicle() is encountered and then when vehicle()
    // is again found in the person(), then Vehicle bean won't be created
    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("Muskan Raina");
        person.setVehicle(vehicle());
        return person;
    }

}