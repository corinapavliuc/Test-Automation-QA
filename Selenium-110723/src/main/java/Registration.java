
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Registration {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://suninjuly.github.io/registration1.html");

    }

    @After

    public void tearDown() {

        driver.quit();

    }

    @Test

    public void successRegistration() throws InterruptedException {

        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Smith");

        WebElement EmailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        EmailInputField.sendKeys("smith@gmail.com");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        sleep(10000);// pokazivaet nam 10 sekund kak zapolnjaetsja tablica

        WebElement congratsHeader = driver.findElement(By.cssSelector(".container h1"));

        assertEquals("Congratulations! You have successfully registered!", congratsHeader.getText());//proverjaem, chto posle nazhatija knopki submit na novoj stranici mi vidim privetstvennuju zapisj

    }

    @Test

    public void successRegistrationWithAllFields() throws InterruptedException {

        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Smith");

        WebElement EmailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        EmailInputField.sendKeys("smith@gmail.com");


        WebElement PhoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        PhoneInputField.sendKeys("1236459");

        WebElement AddressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        AddressInputField.sendKeys("Riga");


        sleep(10000);// pokazivaet nam 10 sekund kak zapolnjaetsja tablica

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement congratsHeader = driver.findElement(By.cssSelector(".container h1"));
        assertEquals("Congratulations! You have successfully registered!", congratsHeader.getText());//proverjaem, chto posle nazhatija knopki submit na novoj stranice mi vidim privetstvennuju zapisj
        assertEquals("https://suninjuly.github.io/registration_result.html?",
                driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("registration_result"));
    }

@Test
    public void  registrationWithoutFirstName() {

        WebElement lastNameInputField=driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Smith");

        WebElement EmailInputField=driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        EmailInputField.sendKeys("smith@gmail.com");
    WebElement PhoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
    PhoneInputField.sendKeys("1236459");

    WebElement AddressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
    AddressInputField.sendKeys("Riga");

        WebElement submitButton=driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        assertTrue(driver.getCurrentUrl().contains("registration1"));

        WebElement firstNameInputField = driver.findElement(By.cssSelector
                ("[placeholder='Input your first name']"));
        assertEquals("Please fill in this field.", firstNameInputField.getAttribute("validationMessage"));
    }
    @Test
    public void registrationWithoutLastName(){
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement EmailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        EmailInputField.sendKeys("smith@gmail.com");
        WebElement PhoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        PhoneInputField.sendKeys("1236459");

        WebElement AddressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        AddressInputField.sendKeys("Riga");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        assertTrue(driver.getCurrentUrl().contains("registration1"));
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        assertEquals("Please fill in this field.", lastNameInputField.getAttribute("validationMessage"));
    }
@Test
    public void registrationWithoutEmail(){
    WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
    firstNameInputField.sendKeys("John");

    WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
    lastNameInputField.sendKeys("Smith");
    WebElement PhoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
    PhoneInputField.sendKeys("1236459");

    WebElement AddressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
    AddressInputField.sendKeys("Riga");

    WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
    submitButton.click();

    assertTrue(driver.getCurrentUrl().contains("registration1"));
    WebElement EmailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
    assertEquals("Please fill in this field.", EmailInputField.getAttribute("validationMessage"));

    }

}






