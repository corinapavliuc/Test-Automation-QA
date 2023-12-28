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

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDrown {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://suninjuly.github.io/selects2.html");

    }



    @After

    public void tearDown() {

        driver.quit();

    }



  @Test
    public void  dropDownTest() throws InterruptedException {
      WebElement num1= driver.findElement(By.id("num1"));
      WebElement num2= driver.findElement(By.id("num2"));
      int sum= parseInt (num1.getText())+parseInt(num2.getText());
      WebElement dropDown = driver.findElement(By.id("dropdown"));
      dropDown.click();
      WebElement answerOption = driver
              .findElement(By.cssSelector("[value='" + sum + "']"));
      ///button//
      answerOption.click();
      WebElement submitButton = driver.findElement(By.tagName("button"));
      submitButton.click();
      //check that alert has text "Congrats, you've passed the task!"
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

  }
}
