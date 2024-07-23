package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class katalon {

    @Test

    public void appointment() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       List<WebElement> username1 = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username1.get(1).sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");


        WebElement text = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center' ]"));
        System.out.println(text.getText());
        Assert.assertEquals(text.getText(), "Make Appointment");

        WebElement date = driver.findElement(By.id("txt_visit_date"));
        date.sendKeys("12/07/2024");

        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("fever");

        WebElement app = driver.findElement(By.id("btn-book-appointment"));
        app.click();


        WebElement confirmation = driver.findElement(By.tagName("p"));
        System.out.println(confirmation.getText());
        Assert.assertEquals(confirmation.getText(), "Please be informed that your appointment has been booked as following:");

        Thread.sleep(5000);

        driver.quit();


    }




}
