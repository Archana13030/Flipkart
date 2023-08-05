package SeleniumPackage;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class Search {
    ChromeOptions options;
    WebDriver driver;
    @BeforeSuite
    public void setUp()
    {
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver= new ChromeDriver(options);
    }
    @Test
    @Description("Launching URL")
    public void Search() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        //driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Laptop");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[text()='Fashion']")).click();
        driver.findElement(By.xpath("//img[@alt='Fashion']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@alt='Shavya Printed Fashion Silk Blend Saree']")).click();
        Thread.sleep(2000);



    }


    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}

