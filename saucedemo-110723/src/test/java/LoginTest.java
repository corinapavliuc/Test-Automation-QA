import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends  BaseTest {


    @Test

    public void successFullLoginWithoutPO() throws InterruptedException {

        WebElement userNameInputField = driver.findElement(By.id("user-name"));

        userNameInputField.sendKeys("standard_user");

        WebElement passwordInputField = driver.findElement(By.id("password"));

        passwordInputField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginButton.click();

        sleep(3000);

        //Check that auth is successful

        //WebElement title = driver.findElement(By.className("title"));

        //assertEquals("Products",title.getText());

        assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));

        assertTrue(inventoryList.isDisplayed());


    }


    @Test

    public void successLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");

        loginPage.enterPassword("secret_sauce");

        loginPage.clickOnLoginButton();

    InventoryPage invetatoryPage = new InventoryPage(driver);

        assertTrue(invetatoryPage.inventoryListIsDisplayed());

    }


    @Test

    public void invalidPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");

        loginPage.enterPassword("secret");

        loginPage.clickOnLoginButton();

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageGetText());

    }

    @Test

    public void lockedOutUser() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("locked_out_user");

        loginPage.enterPassword("secret_sauce");

        loginPage.clickOnLoginButton();

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.errorMessageGetText());

    }

    @Test

    public void elementsAreDisplayed() {

        //check that logo, username section and password section are displayed

        LoginPage loginPage = new LoginPage(driver);

        assertTrue(loginPage.logoIsDisplayed());

        assertTrue(loginPage.credentialsIsDisplayed());

        assertTrue(loginPage.passwordIsDisplayed());

    }

    @Test

    public void successLogout() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

      InventoryPage invetatoryPage = new InventoryPage(driver);
        assertTrue(invetatoryPage.inventoryListIsDisplayed());

        Header header = new Header(driver);
        header.clickOnBurgerMenu();
      //Follow the link Logout
        SideBar sideBar =  new SideBar(driver);
        sideBar.followTheLogoutLink();
        //Assert that logout is succesfull
        assertTrue(loginPage.usernameFieldIsDisplayed());
        // all items names are started from "Sauce Labs"
        assertTrue(invetatoryPage.allNamesStartWithSauceLab());

    }

}

