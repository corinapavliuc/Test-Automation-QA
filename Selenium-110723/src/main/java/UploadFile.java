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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://suninjuly.github.io/file_input.html");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public  void uploadFileTest() throws InterruptedException {
        WebElement firstNameInputField=driver.findElement(By.cssSelector("[placeholder='Enter first name']"));
        firstNameInputField.sendKeys("Corina");
        WebElement lastNameInputField=driver.findElement(By.cssSelector("[placeholder='Enter last name']"));
        lastNameInputField.sendKeys("Pavliuc");
        WebElement EmailInputField=driver.findElement(By.cssSelector("[placeholder='Enter email']"));
        EmailInputField.sendKeys("test1@gmail.com");
        WebElement uploadFile= driver.findElement(By.id("file"));
        uploadFile.sendKeys("C:\\Users\\Tel-ran.de\\Downloads\\textfile.txt");

        //Push Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        submitButton.click();

        //Alert has text "Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
}

