package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


                // תרחיש 1: מילוי תקין עד הדף השלישי וקבלת הודעה ירוקה

                driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");

                driver.findElement(By.id("firstname")).sendKeys("בת שבע");
                driver.findElement(By.id("lastname")).sendKeys("כהן");
                driver.findElement(By.id("email")).sendKeys("test@example.com");
                driver.findElement(By.id("next")).click();

                Thread.sleep(500);
                driver.findElement(By.id("Beginner")).click();
                driver.findElement(By.id("next")).click();

                Thread.sleep(500);
                driver.findElement(By.id("streetname")).sendKeys("הרצל");
                driver.findElement(By.id("streetnumber")).sendKeys("15");
                driver.findElement(By.id("city")).sendKeys("ירושלים");
                driver.findElement(By.id("finish")).click();

                Thread.sleep(1000);
                WebElement greenAlert = driver.findElement(By.id("alert"));
                if (greenAlert.isDisplayed()) {
                    System.out.println("תרחיש 1 הצליח! ההודעה הירוקה: " + greenAlert.getText());
                }

        // תרחיש 2: כניסה מחדש, הגעה לדף השלישי וקבלת הודעה אדומה בסוף

        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");

        // דף 1: מילוי תקין
        driver.findElement(By.id("firstname")).sendKeys("בת שבע");
        driver.findElement(By.id("lastname")).sendKeys("כהן");
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("next")).click();

        Thread.sleep(500);
        driver.findElement(By.id("Beginner")).click();
        driver.findElement(By.id("next")).click();

        Thread.sleep(500);
        driver.findElement(By.id("streetname")).sendKeys("א");
        driver.findElement(By.id("streetnumber")).sendKeys("abc");
        driver.findElement(By.id("city")).sendKeys("א");
        driver.findElement(By.id("finish")).click();

        Thread.sleep(1000);
        WebElement redAlert = driver.findElement(By.id("alert"));
        if (redAlert.isDisplayed()) {
            System.out.println("תרחיש 2 הצליח! ההודעה האדומה: " + redAlert.getText());
        }

                driver.quit();

    }
}