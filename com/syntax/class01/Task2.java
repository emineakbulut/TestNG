package com.syntax.class01;

import org.testng.annotations.*;

/*
Task 1: Executing different test based TestNG annotations
Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation
 */
public class Task2 {

    @BeforeClass
    public void beforeClass (){
        System.out.println("Before class test");
    }
    @BeforeMethod
    public void methodTestBefore() {
        System.out.println("MethodTest before test");
    }
    @Test
    public void method1 (){
        System.out.println("Method1 test");
    }
    @Test
    public void method2(){
        System.out.println("Method2 test");
    }

    @AfterMethod
    public void methodTestAfter(){
        System.out.println("MethodTest after test");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class test");
    }
}
