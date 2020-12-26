package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependOnDemo {

    @Test(priority=1)
    public void login(){
        System.out.println("I am login");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "login")//if login fails this test method will get ignored
    public void addEmployee(){
        System.out.println("I am adding Employee");
    }
//    @Test
//    public void test3(){
//        System.out.println("I am test 3");
//    }

}
