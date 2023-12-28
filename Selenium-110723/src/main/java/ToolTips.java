import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTips {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/tool-tips");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public  void toolTipsTest() throws InterruptedException {

        sleep(7000);WebElement toolButton = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);actions.moveToElement(toolButton).perform();

        WebElement popUp = driver.findElement(By.cssSelector("[class='tooltip-inner']"));

        sleep(7000);
        assertEquals("You hovered over the Button", popUp.getText());

        sleep(7000);

        WebElement inputField = driver.findElement(By.id("toolTipTextField"));

        actions.moveToElement(inputField).perform();
        sleep(7000);

        WebElement hooverText = driver.findElement(By.cssSelector("[class='tooltip-inner']"));

        assertEquals("You hovered over the text field", hooverText.getText());
        sleep(7000);
//
//        sleep(2000);
//        WebElement toolButton = driver.findElement(By.id("toolTipButton"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(toolButton).perform();
//
//        WebElement popUp = driver.findElement(By.cssSelector("[class='tooltip-inner']"));
//        sleep(2000);
//        assertEquals("You hovered over the Button", popUp.getText());
//        sleep(3000);
//
//        WebElement inputField = driver.findElement(By.id("toolTipTextField"));
//        actions.moveToElement(inputField).perform();
//        sleep(2000);
//
//        WebElement hooverText = driver.findElement(By.cssSelector("[class='tooltip-inner']"));
//        assertEquals("You hovered over the text field", hooverText.getText());
    }

    }
