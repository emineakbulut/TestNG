package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnDemo {
//every test is independent unless you use dependsOn.
    @Test(priority=1,groups = "smoke")
    public void login(){
        System.out.println("I am login");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "login",groups = "regression")//if login fails this test method will get ignored
    public void addEmployee(){
        System.out.println("I am adding Employee");
    }


}
