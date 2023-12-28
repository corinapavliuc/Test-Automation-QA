import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeForm {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Dimension dimension = new Dimension(1024,768);
        driver.manage().window().setSize(dimension);
        driver.get("https://demoqa.com/automation-practice-form");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public void allValidData() throws InterruptedException {
        // Steps
        WebElement firstNameInputField =driver.findElement(By.id("firstName"));
        firstNameInputField.sendKeys("Corina");
        WebElement lastNameInputField=driver.findElement(By.id("lastName"));
        lastNameInputField.sendKeys("Pavliuc");
        WebElement EmailInputField=driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
        EmailInputField.sendKeys("test1@gmail.com");
        WebElement gender = driver.findElement(By.id("gender-radio-2"));
        gender.click();
        WebElement mobileNumber = driver.findElement(By.cssSelector("[placeholder='Mobile Number']"));
        mobileNumber.sendKeys("34567889996");
        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.sendKeys("12 Dec 2023");
        WebElement subject = driver.findElement(By.id("subjectsContainer"));
        subject.sendKeys("12 Dec 2023");

        WebElement hobbies = driver.findElement(By.id("hobbies-checkbox-1"));
        hobbies.click();
        WebElement uploadFile= driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys("C:\\Users\\Tel-ran.de\\Downloads");
        //Check that submitting was  successful
         WebElement address = driver.findElement(By.cssSelector("[placeholder='Current Address']"));
         address.sendKeys("Riga");
         WebElement selectState = driver.findElement(By.id("state"));
         selectState.click();
         WebElement state = driver.findElement(By.name("Uttar Pradesh"));
         state.click();
         WebElement city =driver.findElement(By.id("city"));
         city.click();
         WebElement cityName =driver.findElement(By.name("Agra"));
         cityName.click();
         WebElement submitButton = driver.findElement(By.id("submit"));
         submitButton.click();

    }

}
