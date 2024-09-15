package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());
        /*
        The var keyword was introduced in Java 10. Type inference is used in
        var keyword in which it detects automatically the datatype of a variable
        based on the surrounding context.
        * */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Here bean name is same as POJO (object) name and bean is called with this name only
        // If name parameter is not given, along with datatype of Bean, then exception comes :-
        //  NoUniqueBeanDefinitionException

        Vehicle veh1 = context.getBean("veh1" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh1.getName());

        Vehicle veh2 = context.getBean("vehicle2" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());

        Vehicle veh3 = context.getBean("vehicle3" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh3.getName());

//        Vehicle veh1 = context.getBean( Vehicle.class);
//        System.out.println("Vehicle name from Spring Context is: " + veh1.getName());
//
//        Vehicle veh2 = context.getBean( Vehicle.class);
//        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());


    }
}
