package com.example.main;

import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class prototypeScope {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("beans.xml");
        Vehicle vehicle = context.getBean("vehicle" , Vehicle.class );
        Vehicle vehicle2 = context.getBean("vehicle" , Vehicle.class );

        System.out.println("Vehicle name from Spring context is " + vehicle.getName());
        System.out.println("Vehicle2 name from Spring context is " + vehicle2.getName());

        System.out.println("--------------------------");
        vehicle2.setName("McLaren");

        System.out.println("Vehicle name from Spring context is " + vehicle.getName());
        System.out.println("Vehicle2 name from Spring context is " + vehicle2.getName());

    }
}
