import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void allLinksAreDisplayed(){
        //Auth
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());
        //Go to burger menu
        Header header= new Header(driver);
        header.clickOnBurgerMenu();
        //Check that all links are displayed
        SideBar sideBar =new SideBar(driver);
        sideBar.allItemsLinkIsDisplayed();
        sideBar.aboutLinkIsDisplayed();
        sideBar.logoutLinkIsDisplayed();
        sideBar.resetAppStateLinkIsDisplayed();


    }
}
