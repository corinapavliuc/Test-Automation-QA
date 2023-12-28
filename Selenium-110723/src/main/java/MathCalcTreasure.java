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

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalcTreasure {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://suninjuly.github.io/get_attribute.html");

    }



    @After

    public void tearDown() {

        driver.quit();

    }



    public double funcCalc(double x){

        return log(abs(12 * sin(x)));

    }



    @Test

    public void validAnswer () throws InterruptedException {

        WebElement treasureImage = driver.findElement(By.id("treasure"));

        String xValueString = treasureImage.getAttribute("valuex");

        double xValue = parseDouble(xValueString);

        System.out.println(xValue);

        double result = funcCalc(xValue);

        WebElement answerInputField = driver.findElement(By.id("answer"));

        answerInputField.sendKeys(String.valueOf(result));

        sleep(2000);

        //check checkbox I'm the robot

        WebElement robotCheckbox = driver.findElement(By.id("robotCheckbox"));

        robotCheckbox.click();

        //choose Robots rule

        WebElement robotsRuleRadioButton = driver.findElement(By.id("robotsRule"));

        robotsRuleRadioButton.click();

        //push Submit button

        WebElement submitButton = driver.findElement(By.tagName("button"));

        sleep(2000);

        submitButton.click();

        //check that alert has text "Congrats, you've passed the task!"

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());

        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

        sleep(2000);

    }

}