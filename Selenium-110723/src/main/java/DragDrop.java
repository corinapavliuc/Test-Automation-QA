import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragDrop {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");

    }


    @After

    public void tearDown() {

        driver.quit();

    }

    @Test

    public void firstAlertTest() throws InterruptedException {

        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        //actions.dragAndDrop(draggable, droppable).perform();



        actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().build().perform();

        sleep (3000);

        //check that "Dropped!" text is displayed

        assertEquals("Dropped!", droppable.getText());

    }

}
