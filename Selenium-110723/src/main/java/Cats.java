

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;



import java.util.List;



import static org.junit.Assert.*;



public class Cats {

    ChromeDriver driver;

    @Before

    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64\\chromedriver-win64" + "\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://suninjuly.github.io/cats.html");

    }

    @Test

    public void headerTextTest(){

        WebElement header = driver.findElement(By.cssSelector("[class=\"jumbotron-heading\"]"));

        System.out.println(header.getText());

        assertEquals("Cat memes", header.getText());



    }

    @Test

    public void timeFirstCatCard (){

        WebElement timeFirstCatCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][1]//small"));

        System.out.println(timeFirstCatCard.getText());

        assertEquals("9 mins", timeFirstCatCard.getText());

    }



    //check that "I love you so much" in name of last card
    @Test

    public void lastCardTextTest () {

        WebElement lastCardText = driver.findElement(By.xpath("//div[@class='col-sm-4'][6]//p"));

        System.out.println(lastCardText.getText());

        assertEquals("I love you so much", lastCardText.getText());

    }

    @Test

    public void catsAlbumTitleTest (){

        WebElement catsAlbumTitle = driver.findElement(By.tagName("strong"));

        assertTrue(catsAlbumTitle.isDisplayed());

    }



    //first cat card is displayed
    @Test

    public void firstCatCardTest (){

        WebElement firstCatCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][1]"));

        assertTrue(firstCatCard.isDisplayed());

    }



    //check that 6 card
    @Test

    public void checkCardsQuantity () {

        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));

        assertEquals(6, cards.size() );

    }


//check that 6 images are on the page
    @Test

    public void checkPhotosQuantity () {

        List<WebElement> photos = driver.findElements(By.tagName("img"));


    }

    //check that all cards are dispalayed
    @Test
    public void CheckAllCardDisplayed (){
        List<WebElement> cards =driver.findElements(By.className("col-sm-4"));
//        for(WebElement card: cards){
//            assertTrue(card.isDisplayed());}
        cards.forEach(card -> assertTrue(card.isDisplayed()));

    }

    //Chack that all cards have np empty names
    @Test
    public void allCardsAreNotEmpty(){
        List<WebElement> names =driver.findElements(By.tagName("p"));
        for (WebElement name : names) {
            assertFalse(name.getText().isEmpty());
        }
    }



    @After

    public void tearDown (){

        driver.quit();

    }

}

