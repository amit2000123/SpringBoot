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

        // Note :- If the name is given with @Bean Annotation, then the Bean name is changed to this name and
        // not to the name of object and this name should be used with getBean method, otherwise it
        // will give NoUniqueBeanDefinitionException


        Vehicle veh1 = context.getBean("Mercedez" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh1.getName());

        Vehicle veh2 = context.getBean("Ford" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());

        Vehicle veh3 = context.getBean("Ferrari" , Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh3.getName());

//        Vehicle veh1 = context.getBean( Vehicle.class);
//        System.out.println("Vehicle name from Spring Context is: " + veh1.getName());
//
//        Vehicle veh2 = context.getBean( Vehicle.class);
//        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());


    }
}
