package com.syntax.class04;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class Task {
    //TC 1: HRMS Add Employee:
    //
    //Open chrome browser
    //Go to HRMS
    //Login into the application
    //Add 5 different Employees and create login credentials by providing:
    //First Name
    //Last Name
    //Username
    //Password
    //Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
    //Close the browser
    //Specify group for this test case, add it into specific suite and execute from xml file.
    WebDriver driver;
    public String usernameAdmin = "Admin";
    public String passwordAdmin = "Hum@nhrm123";
    @BeforeMethod
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @Test(dataProvider = "AddEmployee", groups = "regression")
    public void AddEmployees(String firstName, String lastName, String userName, String password) throws InterruptedException, IOException {
        //log in
        driver.findElement(By.id("txtUsername")).sendKeys(usernameAdmin);
        driver.findElement(By.id("txtPassword")).sendKeys(passwordAdmin);
        driver.findElement(By.id("btnLogin")).click();
        //
        WebElement menu = driver.findElement(By.xpath("//a[@id = 'menu_pim_viewPimModule']/b"));
        //using js to click on a PIM button
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",menu);
        //menu.click();
        WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
        js.executeScript("arguments[0].click()",addEmployee);
        ///adding employee
        WebElement addFistName = driver.findElement(By.cssSelector("input#firstName"));
        WebElement addLastName = driver.findElement(By.cssSelector("input#lastName"));
        addFistName.sendKeys(firstName);
        addLastName.sendKeys(lastName);
        driver.findElement(By.cssSelector("input#chkLogin")).click();
        //adding log in credentials
        WebElement addUserName = driver.findElement(By.cssSelector("input#user_name"));
        WebElement addPassword = driver.findElement(By.cssSelector("input#user_password"));
        WebElement confirmPassword = driver.findElement(By.cssSelector("input#re_password"));
        addUserName.sendKeys(userName);
        addPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        WebElement saveButton = driver.findElement(By.cssSelector("input#btnSave"));
        saveButton.click();
        //validating that employee is added successfully
        WebElement title = driver.findElement(By.xpath("//div[@id='content']/div/div/div/h1[1]"));
        Assert.assertTrue(title.isDisplayed(), "Name is displayed");

    }
    @DataProvider
    public Object[][] AddEmployee() {
        Object[][] data = new Object[5][4];
        data[0][0] = "Emine";
        data[0][1] = "Eris";
        data[0][2] = "Eeris";
        data[0][3] = "Pass1234@";
        data[1][0] = "Kubra";
        data[1][1] = "Aydin";
        data[1][2] = "Kaydin";
        data[1][3] = "Pass1234@";
        data[2][0] = "Busra";
        data[2][1] = "Aydin";
        data[2][2] = "Baydin";
        data[2][3] = "Pass1234@";
        data[3][0] = "Rana";
        data[3][1] = "Guler";
        data[3][2] = "Rguler";
        data[3][3] = "Pass1234@";
        data[4][0] = "Azra";
        data[4][1] = "Sandal";
        data[4][2] = "Asandal";
        data[4][3] = "Pass1234@";
        return data;
    }
}
