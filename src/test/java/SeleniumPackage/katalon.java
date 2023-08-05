package SeleniumPackage;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class katalon {
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
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        Thread.sleep(5000);
        //driver.findElement(By.id("//select[@id='combo_facility']"));
        Select Facility = new Select(driver.findElement(By.xpath("//select[@id='combo_facility']")));
        Facility.selectByVisibleText("Hongkong CURA Healthcare Center");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
//        driver.findElement(Email).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();

        //Calendar
        WebElement dateBox = driver.findElement(By.id("txt_visit_date"));

        //Fill date as mm/dd/yyyy as 09/25/2023

        dateBox.sendKeys("09252023");

        //Press tab to shift focus to time field

        dateBox.sendKeys(Keys.TAB);
//button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        Thread.sleep(5000);

    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
