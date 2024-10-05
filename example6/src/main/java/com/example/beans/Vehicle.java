package com.example.beans;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Vehicle {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//@PostConstruct also depends on the Springboot version
// As the table above shows, with Spring 6.0.x and 6.1.x,
// we should use the jakarta namespace. However, if our project
// uses Spring 5.3.x and JDK 9 or a later version,
// since Spring 5.3.x only supports the javax namespace,
// we must explicitly add the javax.annotation-api dependency to our project:
// https://www.baeldung.com/spring-postconstruct-predestroy#javaxannotation-or-jakartaannotation

    @PostConstruct
    public void initialize() {
        this.name = "Honda";
    }

    public void printHello(){
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
