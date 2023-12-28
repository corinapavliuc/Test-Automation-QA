import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest extends BaseTest {
    //add 1 product in der card
    @Test
    public void checkCartBadgeWithQuantity() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());
        // add backpack
        invetatoryPage.backPackAddToCart();
        // check card badge
        Header header = new Header(driver);
        assertEquals(1, header.getQuantityOfCartBadge());

    }

    // add 3 produck in der card
    @Test
    public void checkCartBadgeWithQuantity3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());
        // add backpack
        invetatoryPage.backPackAddToCart();
        invetatoryPage.bikeLightAddToCart();
        invetatoryPage.tShirtAddToCart();
        // check card badge
        Header header = new Header(driver);
        assertEquals(3, header.getQuantityOfCartBadge());
    }

    //add 4 product in der card
    @Test
    public void checkCartBadgeWithQuantity4Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());
        // add backpack
        invetatoryPage.backPackAddToCart();
        invetatoryPage.bikeLightAddToCart();
        invetatoryPage.tShirtAddToCart();
        invetatoryPage.sauceLabsOnesie();
        // check card badge
        Header header = new Header(driver);
        assertEquals(4, header.getQuantityOfCartBadge());
    }
    //add Sauce Labs Backpack

    @Test
    public void backpackAddedToCart(){
      //Auth

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        //add backpack
        inventoryPage.backPackAddToCart();

        //go to Shopping Cart

        Header header = new Header(driver);
        header.getQuantityOfCartBadge();

        //check item

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getInventoryName().contains("Sauce Labs Backpack"));

    }

    }
