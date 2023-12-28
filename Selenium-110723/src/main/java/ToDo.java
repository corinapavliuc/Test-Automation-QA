import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDo {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/todo-app.html");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public  void crossFristLineAfterCheck() throws InterruptedException {
        WebElement firstCheckBox = driver.findElement(By.cssSelector("[name=\"todo-1\"]"));
        firstCheckBox.click();
        WebElement firstLineText= driver.findElement(By.cssSelector("[name=\"todo-1\"]~span"));
        assertEquals("done-true",firstLineText.getAttribute("class"));

    }


}
