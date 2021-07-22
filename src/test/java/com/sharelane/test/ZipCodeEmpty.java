package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeEmpty {

    @Test
    public void zipCodeEmptyTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "F:\\QA12WorkSpace\\Webdriver1\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https:www.Sharelane.com");
        // Open 'ShareLane' login page
        // Click on the "Sing up" button
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Fill the form with the required ZIP code

        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'][value='Continue']"));
        continueButton.click();
        WebElement errorMessageElement = driver.findElement(By.className("error_message"));
        String errorMessage = errorMessageElement.getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
    }
}
