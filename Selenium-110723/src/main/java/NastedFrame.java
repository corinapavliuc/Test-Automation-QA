import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NastedFrame {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/nestedframes");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    @Test
    public void nestedFrameTest(){
        // Check test "Parent frame "
        driver.switchTo().frame("frame1");
        WebElement parentFrametest = driver.findElement(By.tagName("body"));
        assertEquals("Parent frame",parentFrametest.getText());
        //check text "Child Iframe"
        WebElement frame2 =driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame2);
        WebElement childIframeTest = driver.findElement(By.tagName("p"));
        assertEquals("Child Iframe",childIframeTest.getText());
    }
}
