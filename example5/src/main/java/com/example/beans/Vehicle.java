package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String Name ;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void printHello(){
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
