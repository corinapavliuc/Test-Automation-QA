import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Alerts {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        //driver.manage().window().maximize();

        Dimension dimension = new Dimension(2040,790);

        driver.manage().window().setSize(dimension);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demoqa.com/alerts");
    }


    @After

    public void tearDown() {

        driver.quit();

    }

    @Test

    public void firstAlertTest(){

        WebElement alertButton = driver.findElement(By.id("alertButton"));

        alertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("You clicked a button"));

    }

    @Test

    public void secondAlertTest(){

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));

        timerAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("This alert appeared after 5 seconds"));

    }

    @Test

    public void alertConfirm(){

        //WebElement confirmButton = driver.findElement(By.id("confirmButton"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmButton")));

        confirmButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertTrue(alert.getText().contains("Do you confirm action?"));

        alert.accept();

        WebElement confirmResult = driver.findElement(By.id("confirmResult"));

        assertEquals("You selected Ok", confirmResult.getText());

    }

    @Test

    public void alertCancel(){

        WebElement thirdButton = driver.findElement(By.id("confirmButton"));

        thirdButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.dismiss();

        WebElement confirmResult = driver.findElement(By.id("confirmResult"));

        assertEquals("You selected Cancel", confirmResult.getText());

    }

    @Test

    public void alertInput(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement promptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));
        promptButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String name = "Anna";

        alert.sendKeys(name);

        alert.accept();

        WebElement promptResult = driver.findElement(By.id("promptResult"));

        assertEquals("You entered " + name, promptResult.getText());

    }

    }
