package com.syntax.class01;
/*
US 17666 Syntax Logo should be present on the login page
US 17667 Error message “Invalid credentials” should be displayed when user enters invalid credentials
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test(priority = 0)
    public void isImagePresent(){
        WebElement element=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        if (element.isDisplayed()){
            System.out.println("Image is present.Test pass.");
        }else{
            System.out.println("Image is not present.Test failed.");
        }
    }
    @Test(priority = 1,enabled = true)
    public void invalidCredentials(){
        driver.findElement(By.id("txtUsername")).sendKeys("Syntaxx");
        driver.findElement(By.id("txtPassword")).sendKeys("000123");
        driver.findElement(By.id("btnLogin")).click();
        String error=driver.findElement(By.id("spanMessage")).getText();
        String ExpectedErrorMessage="Invalid credentials";
        if (error.equals(ExpectedErrorMessage)){
            System.out.println("Invalid credentials displayed.Test pass. ");
        }else{
            System.out.println("Invalid credentials is not displayed. Test failed");
        }
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

}
