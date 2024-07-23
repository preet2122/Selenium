package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidLogin {

    @Test

    public void VWinvalidlogin() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Login - VWO");


        WebElement inputemail = driver.findElement(By.id("login-username"));
        inputemail.sendKeys("admin@adin.com");

        WebElement inputpassword = driver.findElement(By.id("login-password"));
        inputpassword.sendKeys("12345");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

        Thread.sleep(5000);


        WebElement errormessage = driver.findElement(By.className("notification-box-description"));
        System.out.println(errormessage.getText());
        Assert.assertEquals(errormessage.getText(), "Your email, password, IP address or location did not match");

        Thread.sleep(5000);

        driver.quit();


    }


}
