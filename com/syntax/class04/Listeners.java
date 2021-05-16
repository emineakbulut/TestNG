package com.syntax.class04;

import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class Listeners implements ITestNGListener {

    public void onTestStart(ITestResult result){
        System.out.println("Starting test with name  "+result.getName());;//returns the name of the test method
    }

    public void onTestSucces(ITestResult result){
        System.out.println("Test pass,we are taking screenshot");
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test fail we are taking screenshot");
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Finising test with name "+result.getName());    }
}
