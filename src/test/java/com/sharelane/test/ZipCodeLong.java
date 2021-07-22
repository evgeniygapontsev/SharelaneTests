package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeLong {

    @Test
    public void zipCodeTestLong(){
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
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'][value='Continue']"));
        continueButton.click();

    }
}
