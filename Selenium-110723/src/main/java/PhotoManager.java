import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class PhotoManager {
    ChromeDriver driver;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
        driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

    }


    @After

    public void tearDown() {

        driver.quit();

    }
    /// le punem toate pozele in gunoi
    @Test
    public void moveAllPhotosToTrash() throws InterruptedException {
        WebElement demoFrame =driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(demoFrame);
        List<WebElement> photos = driver.findElements(By.className(".ui-draggable-handle"));
        Actions actions = new Actions(driver);
        WebElement trash =driver.findElement(By.xpath("//div[@id='trash']"));
        for (WebElement photo : photos){
            actions.dragAndDrop(photo,trash).perform();
        }
      sleep(3000);

    /// le scoatem toate pozele din gunoi

        for (WebElement photo : photos){
            sleep(1000);
            WebElement recucle = driver.findElement(By.cssSelector("[title='Recycle this image']"));
            actions.moveToElement(photo).moveToElement(recucle).click().build().perform();
        }
        sleep(3000);
    }
}
