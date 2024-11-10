package com.example.main;

import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example8 {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle vehicle = context.getBean("vehicle" , Vehicle.class );
        System.out.println("Vehicle name from Spring context is " + vehicle.getName());
//        Vehicle vehicle = context.getBean("vehicle2" , Vehicle.class );   this will print "Honda"
//        Vehicle vehicle = context.getBean("vehicleBean" , Vehicle.class );   this will also print "Honda"
//        Vehicle vehicle = context.getBean("vehicle" , Vehicle.class );   this will also print "Ferrari"

    }
}
