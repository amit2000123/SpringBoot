package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");

        // Supplier function is just like lambda function,
        // they don't take any input and only supply values
        Supplier volkwagenSupplier = ()-> volkswagen;          // one-liner supplier function

        Supplier audiSupplier = () -> {              //multi-liner supplier function
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("Random Number is " + randomNumber);
        if(randomNumber % 2 == 0){
            context.registerBean("volkswagen" ,  Vehicle.class , volkwagenSupplier);
        }
        else{
            context.registerBean("audi" ,  Vehicle.class , audiSupplier);
        }
// As we're randomly generating number and checking if the number is odd or even and based on
// that, we are creating bean. So, at a time only one of the two bean will be created and
// that's why we also have to check which Bean is created

        Vehicle volksVehicle  = null;
        Vehicle audiVehicle  = null;

        try{
            volksVehicle = context.getBean("volkswagen" , Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating volkswagen car");
        }

        try{
            audiVehicle = context.getBean("audi" , Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating audi car");
        }

        if(volksVehicle != null){
            System.out.println("Programming Vehicle name from Spring context is : " + volksVehicle.getName());
        }else {
            System.out.println("Programming Vehicle name from Spring context is : " + audiVehicle.getName());
        }



        context.close();
    }
}
