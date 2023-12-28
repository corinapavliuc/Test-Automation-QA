import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginForm {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/login-form.html");

    }


    @After

    public void tearDown() {

        driver.quit();

    }

    @Test
    public void successLoginValidDate() {
        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys("tester@crossbrowsertesting.com");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test123");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement uniqueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logged-in-message")));
        WebElement loginText = driver.findElement(By.id("logged-in-message"));
        assertEquals("Welcome tester@crossbrowsertesting.com\n" +
                "You are now logged in!", loginText.getText());

    }


    @Test
    public void invalidData() {
        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys("tester@");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test12367");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement uniqueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));
        WebElement errorText = driver.findElement(By.className("ng-binding"));
        assertEquals("Username or password is incorrect", errorText.getText());
    }


    @Test
    public void emptyUsername() {
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test123");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement errorText = driver.findElement(By.id("username"));
        assertEquals("Please fill in this field.", errorText.getAttribute("validationMessage"));
    }

    @Test
    public void emptyPassword() {
        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys(" tester@crossbrowsertesting.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement errorText = driver.findElement(By.id("password"));
        assertEquals("Please fill in this field.", errorText.getAttribute("validationMessage"));
    }
}