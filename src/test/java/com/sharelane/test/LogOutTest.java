package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogOutTest {

    @Test
    public void logOutPositive(){

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
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'][value='Continue']"));
        continueButton.click();
        // Fill in the fields
        WebElement firstName = driver.findElement(By.cssSelector("[name=\"first_name\"]"));
        firstName.sendKeys("Bilbo");

        WebElement lastName = driver.findElement(By.cssSelector("[name='last_name']"));
        lastName.sendKeys("Baggins");

        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys("bblotr@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("[name='password1']"));
        password.sendKeys("12345");

        WebElement confirmPassword = driver.findElement(By.cssSelector("[name='password2']"));
        confirmPassword.sendKeys("12345");
        WebElement register = driver.findElement(By.cssSelector("[type='submit'][value='Register']"));
        register.click();

        // assert that we are signed in
        WebElement confirmationMessageElement = driver.findElement(By.className("confirmation_message"));
        String confirmationMessage = confirmationMessageElement.getText();
        Assert.assertEquals(confirmationMessage, "Account is created!");

        // new login info
        WebElement loginElement = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b"));
        String copyEmail = loginElement.getText();
        WebElement hereButton = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td/p/a"));
        hereButton.click();

        // enter login and password in the fields
        WebElement enterEmail = driver.findElement(By.name("email"));
        enterEmail.sendKeys(new String[]{copyEmail});
        WebElement enterPassword = driver.findElement(By.name("password"));
        enterPassword.sendKeys("1111");
        WebElement singUpButton = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[3]/input"));
        singUpButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //assert that we are logout
        WebElement logOutButton = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/a"));
        logOutButton.click();

        WebElement logOutMessageElement = driver.findElement(By.className("confirmation_message"));
        String logOutMessage = logOutMessageElement.getText();
        Assert.assertEquals(logOutMessage, "You've been logged out");

    }
}
