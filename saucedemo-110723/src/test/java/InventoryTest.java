import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{
    @Test
    public void itemsTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());
        //Quantity of items is 6
      assertEquals(6,invetatoryPage.getInventoryItemSize());
        //all inventory items are displayed
        assertTrue(invetatoryPage.allInventoryItemsAreDisplayed());
        // all items name are not empty
        assertTrue(invetatoryPage.allItemsNameAreNotEmpty());
        //all items' names are started from "Sauce Labs"
        assertTrue(invetatoryPage.allNamesStartWithSauceLab());
    }
}
