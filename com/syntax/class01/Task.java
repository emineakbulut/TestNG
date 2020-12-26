package com.syntax.class01;

import org.testng.annotations.Test;

/*
Task 1: Executing tests using @Test
Create three tests with unique @test methods names.
Execute all test methods
 */
public class Task {

    @Test
    void turkey(){
        System.out.println("I speak Turkish");
    }
    @Test
    void us(){
        System.out.println("I speak English");
    }
    @Test
    void spain(){
        System.out.println("I speak Spanish");
    }
}
