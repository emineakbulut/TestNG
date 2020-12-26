package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionModified {

    WebDriver driver;
    @BeforeMethod
    public void openAndNavigate ( ) {
        System.setProperty ( "webdriver.chrome.driver", "drivers/chromedriver.exe" );
        driver = new ChromeDriver( );
        driver.get ( "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login" );
        driver.manage ( ).window ( ).maximize ( );
        driver.manage ( ).timeouts ( ).implicitlyWait ( 15, TimeUnit.SECONDS );
    }
    @AfterMethod
    public void closeBrowser ( ) {
        driver.quit ( );
    }
    @Test
    //verifying that logo is displayed
    public void logoAndValidLogo(){
        WebElement element = driver.findElement ( By.xpath ( "//*[@id=\"divLogo\"]/img" ) );
        SoftAssert softAssert=new SoftAssert ();
        softAssert.assertTrue (!element.isDisplayed (),"Logo is not displayed" );

        String username="Admin";
        driver.findElement ( By.id ( "txtUsername" ) ).sendKeys ( username );
        driver.findElement ( By.id ( "txtPassword" ) ).sendKeys ( "Hum@nhrm123" );
        driver.findElement ( By.id ( "btnLogin" ) ).click ( );

        WebElement welcomeMessage=driver.findElement ( By.cssSelector ( "a#welcome" ) );
        softAssert.assertTrue ( welcomeMessage.isDisplayed ( ),"Welcome message is not displayed" );
        softAssert.assertEquals ( welcomeMessage.getText (),"Welcome "+username );
        System.out.println ("End of the test case" );
        softAssert.assertAll (  );
    }
    @Test
    public void simpleTest(){
        System.out.println("I am a simple test");
    }
}
