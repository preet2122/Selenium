package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ValidLogin {


    @Test

    public void validllogin() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");

        WebElement Inputbox = driver.findElement(By.id("login-username"));
        Inputbox.sendKeys("vwo@1secmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Vwo@1234");

        WebElement checkbox = driver.findElement(By.className("checkbox-radio-icon"));
        checkbox.isSelected();


        Thread.sleep(8000);

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

        driver.quit();







    }




}
