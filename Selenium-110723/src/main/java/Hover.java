import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public void hoverTest () throws InterruptedException {
        WebElement dropdown = driver.
                findElement(By.xpath("//li[@class=\"dropdown\"]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement secundaryMenu= driver
                .findElement(By.xpath("//li[@class=\"secondary-dropdown\"]/a"));
        actions.moveToElement(secundaryMenu).perform();
        //Push the "Secondary Action" button

        WebElement  secondaryAction = driver
                .findElement(By.xpath("//ul[@class=\"dropdown-menu secondary\"]//li/a"));
secondaryAction.click();
sleep(3000);
        //Check that "Secondary Page" is displayed
        WebElement secondaryHeader = driver
                .findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/h1\n"));
        assertEquals("Secondary Page",secondaryHeader.getText());

       //Check that "Secondary action in the menu was clicked successfully!" is displayed
  WebElement secondaryLowHeader =driver
          .findElement(By.xpath("//div[@class=\"jumbotron secondary-clicked\"]/p[1]\n"));

    }
}
